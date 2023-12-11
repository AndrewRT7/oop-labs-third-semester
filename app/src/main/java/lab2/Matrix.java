package lab2;

import java.util.Arrays;
import java.util.Random;

public class Matrix {

    private int rows;
    private int columns;
    private double[][] data;

    // Matrix
    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new double[rows][columns];
    }

    // Empty matrix
    public Matrix() {
        this.rows = 0;
        this.columns = 0;
        this.data = new double[0][0];
    }
   
    // Copy matrix
    public Matrix(Matrix matrix) {
        this.rows = matrix.getRows();
        this.columns = matrix.getColumns();
        this.data = new double[rows][columns];
        double[][] matrixData = matrix.getData();
        for (int i = 0; i < rows; i++) {
            System.arraycopy(matrixData[i], 0, this.data[i], 0, columns);
        }
    }

    // Matrix from array
    public Matrix(double[][] data) {
        this.rows = data.length;
        this.columns = data[0].length;
        this.data = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(data[i], 0, this.data[i], 0, columns);
        }
    }

    // Fill matrix
    public void setElement(int rows, int columns, double value) {
        data[rows][columns] = value;
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
        Matrix newMatrix = (Matrix) x;
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
    public Matrix add(Matrix other) {
        Matrix result = new Matrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.data[i][j] = this.data[i][j] + other.getElement(i, j);
            }
        }
        return result;
    }

    // Multiply by scalar
    public Matrix multiply(double scalar) {
        Matrix result = new Matrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.data[i][j] = this.data[i][j] * scalar;
            }
        }
        return result;
    }

    // Multiply by matrix
    public Matrix multiply(Matrix other) {
        int otherRows = other.getRows();
        if (columns != otherRows) {
            throw new IllegalArgumentException("Matrix dimensions are not compatible for multiplication.");
        }
        double[][] result = new double[this.rows][other.getColumns()];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.getColumns(); j++) {
                for (int k = 0; k < this.columns; k++) {
                    result[i][j] += this.data[i][k] * other.getElement(k, j);
                }
            }
        }
        return new Matrix(result);
    }

    // Transpose
    public Matrix transpose() {
        double[][] transposedData = new double[columns][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposedData[j][i] = data[i][j];
            }
        }
        return new Matrix(transposedData);
    }

    // Diagonal matrix
    public Matrix diagonalMatrix(double[] diagonalVector) {
        double[][] data = new double[diagonalVector.length][diagonalVector.length];
        for (int i = 0; i < diagonalVector.length; i++) {
            data[i][i] = diagonalVector[i];
        }
        return new Matrix(data);
    }

    // Identity matrix
    public Matrix identityMatrix(int dimension) {
        double[][] data = new double[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            data[i][i] = 1;
        }
        return new Matrix(data);
    }

    // Random row matrix
    public static Matrix randomRowMatrix(int columns) {
        Random random = new Random();
        Matrix rowMatrix = new Matrix(1, columns);
        for (int i = 0; i < columns; i++) {
            double randomValue = random.nextDouble();
            rowMatrix.setElement(0, i, randomValue);
        }
        return rowMatrix;
    }

    // Random column matrix
    public static Matrix randomColumnMatrix(int rows) {
        Random random = new Random();
        Matrix columnMatrix = new Matrix(rows, 1);
        for (int i = 0; i < rows; i++) {
            double randomValue = random.nextDouble();
            columnMatrix.setElement(i, 0, randomValue);
        }
        return columnMatrix;
    }

    // Triangular
    public Matrix[] triangularMatrix() {
        Matrix upperTriangular = new Matrix(this);
        Matrix lowerTriangular = new Matrix(rows, columns);
        if (rows != columns) {
            throw new IllegalArgumentException("Matrix must be square for Gaussian elimination.");
        }
        for (int k = 0; k < rows; k++) {
            lowerTriangular.setElement(k, k, 1.0);
            for (int i = k + 1; i < rows; i++) {
                double factor = upperTriangular.getElement(i, k) / upperTriangular.getElement(k, k);
                lowerTriangular.setElement(i, k, factor);
                for (int j = k; j < columns; j++) {
                    double newValue = upperTriangular.getElement(i, j) - factor * upperTriangular.getElement(k, j);
                    upperTriangular.setElement(i, j, newValue);
                }
            }
        }
        return new Matrix[]{upperTriangular, lowerTriangular};
    }    
   
    // Print matrix
    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(data[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
