package lab2;

import java.util.Arrays;

public final class ImmutableMatrix {

    private final int rows;
    private final int columns;
    private final double[][] data;

    // ImmutableMatrix
    public ImmutableMatrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new double[rows][columns];
    }

    // Empty ImmutableMatrix
    public ImmutableMatrix() {
        this.rows = 0;
        this.columns = 0;
        this.data = new double[0][0];
    }
   
    // Copy ImmutableMatrix
    public ImmutableMatrix(Matrix matrix) {
        this.rows = matrix.getRows();
        this.columns = matrix.getColumns();
        this.data = new double[rows][columns];
        double[][] matrixData = matrix.getData();
        for (int i = 0; i < rows; i++) {
            System.arraycopy(matrixData[i], 0, this.data[i], 0, columns);
        }
    }

    // ImmutableMatrix from array
    public ImmutableMatrix(double[][] data) {
        this.rows = data.length;
        this.columns = data[0].length;
        this.data = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(data[i], 0, this.data[i], 0, columns);
        }
    }

    // Getters
    public double[][] getData() {
        double[][] copy = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(this.data[i], 0, copy[i], 0, columns);
        }
        return copy;
    }
    

    public int getRows() {
        return rows;
    }
   
    public int getColumns() {
        return columns;
    }

    public double getElement(int rows, int columns) {
        return data[rows][columns];
    }
   
    public double[] getRow(int rows) {
        return data[rows];
    }
   
    public double[] getColumn(int columns) {
        double[] column = new double[rows];
        for (int i = 0; i < rows; i++) {
            column[i] = data[i][columns];
        }
        return column;
    }

    public String getDimension() {
        return "Rows: " + rows + ", Columns: " + columns;
    }

    // Equals
    @Override
    public boolean equals(Object x) {
        if (this == x) return true;
        if (x == null || getClass() != x.getClass()) return false;
        ImmutableMatrix newMatrix = (ImmutableMatrix) x;
        if (rows != newMatrix.rows || columns != newMatrix.columns) {
            return false;
        }
        for (int i = 0; i < rows; i++) {
            if (!Arrays.equals(data[i], newMatrix.data[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int code = Arrays.deepHashCode(data);
        code = 31 * code + rows;
        code = 31 * code + columns;
        return code;
    }

    // Add
    public ImmutableMatrix add(ImmutableMatrix other) {
        ImmutableMatrix result = new ImmutableMatrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.data[i][j] = this.data[i][j] + other.getElement(i, j);
            }
        }
        return result;
    }

    // Multiply by scalar
    public ImmutableMatrix multiply(double scalar) {
        ImmutableMatrix result = new ImmutableMatrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.data[i][j] = this.data[i][j] * scalar;
            }
        }
        return result;
    }

    // Multiply by ImmutableMatrix
    public ImmutableMatrix multiply(ImmutableMatrix other) {
        int otherRows = other.getRows();
        //if (columns != otherRows) {
        //    throw new IllegalArgumentException("Matrix dimensions are not compatible for multiplication.");
        //}
        double[][] result = new double[this.rows][other.getColumns()];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.getColumns(); j++) {
                for (int k = 0; k < this.columns; k++) {
                    result[i][j] += this.data[i][k] * other.getElement(k, j);
                }
            }
        }
        return new ImmutableMatrix(result);
    }

    // Transpose
    public ImmutableMatrix transpose() {
        double[][] transposedData = new double[columns][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposedData[j][i] = data[i][j];
            }
        }
        return new ImmutableMatrix(transposedData);
    }

    // Diagonal ImmutableMatrix
    public ImmutableMatrix diagonalMatrix(double[] diagonalVector) {
        double[][] data = new double[diagonalVector.length][diagonalVector.length];
        for (int i = 0; i < diagonalVector.length; i++) {
            data[i][i] = diagonalVector[i];
        }
        return new ImmutableMatrix(data);
    }

    // Identity ImmutableMatrix
    public ImmutableMatrix identityMatrix(int dimension) {
        double[][] data = new double[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            data[i][i] = 1;
        }
        return new ImmutableMatrix(data);
    }

    // Random row ImmutableMatrix
    public static ImmutableMatrix randomRowImmutableMatrix(int columns) {
        return new ImmutableMatrix(Matrix.randomRowMatrix(columns));
    }

    // Random column ImmutableMatrix
    public static ImmutableMatrix randomColumnImmutableMatrix(int rows) {
        return new ImmutableMatrix(Matrix.randomRowMatrix(rows));
    }

    // Triangular Immutable
    public ImmutableMatrix[] triangularMatrix() {
        double[][] upperTriangularData = new double[rows][columns];
        double[][] lowerTriangularData = new double[rows][columns];
        if (rows != columns) {
            throw new IllegalArgumentException("Matrix must be square for Gaussian elimination.");
        }
        for (int i = 0; i < rows; i++) {
            System.arraycopy(data[i], 0, upperTriangularData[i], 0, columns);
        }
        for (int k = 0; k < rows; k++) {
            lowerTriangularData[k][k] = 1.0;
            for (int i = k + 1; i < rows; i++) {
                double factor = upperTriangularData[i][k] / upperTriangularData[k][k];
                lowerTriangularData[i][k] = factor;
                for (int j = k; j < columns; j++) {
                    double newValue = upperTriangularData[i][j] - factor * upperTriangularData[k][j];
                    upperTriangularData[i][j] = newValue;
                }
            }
        }
        ImmutableMatrix upperTriangular = new ImmutableMatrix(upperTriangularData);
        ImmutableMatrix lowerTriangular = new ImmutableMatrix(lowerTriangularData);
    
        return new ImmutableMatrix[]{upperTriangular, lowerTriangular};
    }
    
    
    // Print ImmutableMatrix
    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(data[i][j] + "\t");
            }
            System.out.println();
        }
    }
}