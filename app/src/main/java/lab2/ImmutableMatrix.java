package lab2;

import java.util.Arrays;
import java.util.Random;

public final class ImmutableMatrix {

    private int rows;
    private int columns;
    private Double[][] data;
    private Double[][] dataCopy;

    public ImmutableMatrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new Double[rows][columns];
    }

    public ImmutableMatrix(Double[][] data) {
        this.rows = data.length;
        this.columns = data[0].length;
        this.data = new Double[rows][columns];
        this.dataCopy = new Double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                this.data[i][j] = data[i][j];
                this.dataCopy[i][j] = data[i][j];
            }
        }
    }

    public ImmutableMatrix(int rows, int columns, boolean zeroMatrix) {
        this.rows = rows;
        this.columns = columns;
        this.data = new Double[rows][columns];
        if (zeroMatrix) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    this.data[i][j] = 0.0;
                }
            }
        }
    }

    public Double[][] getData() {
        return data;
    }

    public int getRows() {
        return rows;
    }
   
    public int getColumns() {
        return columns;
    }

    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(data[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public Double getElement(int rows, int columns) {
        return data[rows][columns];
    }
   
    public Double[] getRow(int rows) {
        return data[rows];
    }
   
    public Double[] getColumn(int columns) {
        Double[] column = new Double[rows];
        for (int i = 0; i < rows; i++) {
            column[i] = data[i][columns];
        }
        return column;
    }


    public int[] getDimensions() {
        return new int[] {rows, columns};
    }

    @Override
    public boolean equals(Object x) {
        if (this == x) return true;
        if (x == null || getClass() != x.getClass()) return false;
        ImmutableMatrix newMatrix = (ImmutableMatrix) x;
        if (rows != newMatrix.rows || columns != newMatrix.columns) return false;
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

    public ImmutableMatrix add(ImmutableMatrix other) {
        if (this.rows != other.rows || this.columns != other.columns) {
            throw new IllegalArgumentException("Matrix dimensions must be the same for addition.");
        }
        Double[][] resultData = new Double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                resultData[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        return new ImmutableMatrix(resultData);
    }

    public ImmutableMatrix multiply(double scalar) {
        Double[][] resultData = new Double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                resultData[i][j] = this.data[i][j] * scalar;
            }
        }
        return new ImmutableMatrix(resultData);
    }
   
    public ImmutableMatrix multiply(ImmutableMatrix other) {
        int otherRows = other.getRows();
        int otherColumns = other.getColumns();
   
        if (columns != otherRows) {
            throw new IllegalArgumentException("Matrix dimensions are not compatible for multiplication.");
        }
   
        Double[][] resultData = new Double[rows][otherColumns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < otherColumns; j++) {
                Double sum = 0.0;
                for (int k = 0; k < columns; k++) {
                    sum += data[i][k] * other.data[k][j];
                }
                resultData[i][j] = sum;
            }
        }
        return new ImmutableMatrix(resultData);
    }

    public ImmutableMatrix transpose() {
        Double[][] transposedData = new Double[columns][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposedData[j][i] = data[i][j];
            }
        }
        return new ImmutableMatrix(transposedData);
    }

    public ImmutableMatrix(Double[] diagonalVector) {
        int dimension = diagonalVector.length;
        this.rows = dimension;
        this.columns = dimension;
        this.data = new Double[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (i == j) {
                    this.data[i][j] = diagonalVector[i];
                }
                else {
                    this.data[i][j] = 0.0;
                }
            }
        }
    }

    public ImmutableMatrix(int dimension) {
        this.rows = dimension;
        this.columns = dimension;
        this.data = new Double[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (i == j) {
                    this.data[i][j] = 1.0;
                }
                else {
                    this.data[i][j] = 0.0;
                }
            }
        }
    }

    public static ImmutableMatrix randomRowMatrix(int columns) {
        Random random = new Random();
        Double[][] rowMatrixData = new Double[1][columns];
        for (int i = 0; i < columns; i++) {
            rowMatrixData[0][i] = random.nextDouble();
        }
        return new ImmutableMatrix(rowMatrixData);
    }

    public static ImmutableMatrix randomColumnMatrix(int rows) {
        Random random = new Random();
        Double[][] columnMatrixData = new Double[rows][1];
        for (int i = 0; i < rows; i++) {
            columnMatrixData[i][0] = random.nextDouble();
        }
        return new ImmutableMatrix(columnMatrixData);
    }

    public ImmutableMatrix upperTriangular() {
        Double[][] upperTriangularData = new Double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (j < i) {
                    upperTriangularData[i][j] = 0.0;
                } else {
                    upperTriangularData[i][j] = data[i][j];
                }
            }
        }
        return new ImmutableMatrix(upperTriangularData);
    }

    public ImmutableMatrix lowerTriangular() {
        Double[][] lowerTriangularData = new Double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (j > i) {
                    lowerTriangularData[i][j] = 0.0;
                } else {
                    lowerTriangularData[i][j] = data[i][j];
                }
            }
        }
        return new ImmutableMatrix(lowerTriangularData);
    }
}
