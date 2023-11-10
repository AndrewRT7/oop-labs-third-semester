package lab2;

import java.util.Arrays;

public class Matrix {

    private int rows;
    private int columns;
    private Double[][] data;
    private Double[][] dataCopy;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new Double[rows][columns];
    }
   
    public Matrix(Double[][] data) {
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

    public Matrix(int rows, int columns, boolean zeroMatrix) {
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

    public void setElement(int rows, int columns, Double value) {
        data[rows][columns] = value;
    }
   
    public void fillMatrix(Double[][] values) {
        if (values.length == rows && values[0].length == columns) {
            data = values;
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
        Matrix newMatrix = (Matrix) x;
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

    public Matrix add(Matrix other) {
        Matrix result = new Matrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.setElement(i, j, this.getElement(i, j) + other.getElement(i, j));
            }
        }
        return result;
    }

    public Matrix multiply(double scalar) {
        Matrix result = new Matrix(rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result.setElement(i, j, this.getElement(i, j) * scalar);
            }
        }
        return result;
    }

     public Matrix multiply(Matrix other) {
        int otherRows = other.getRows();
        int otherColumns = other.getColumns();
   
        if (columns != otherRows) {
            throw new IllegalArgumentException("Matrix dimensions are not compatible for multiplication.");
        }
   
        Matrix result = new Matrix(rows, otherColumns, true);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < otherColumns; j++) {
                Double sum = 0.0;
                for (int k = 0; k < columns; k++) {
                    sum += data[i][k] * other.getElement(k, j);
                }
                result.setElement(i, j, sum);
            }
        }
        return result;
    }

    public Matrix transpose() {
        Double[][] transposedData = new Double[columns][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposedData[j][i] = data[i][j];
            }
        }
        return new Matrix(transposedData);
    }

    public Matrix(Double[] diagonalVector) {
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

    public Matrix(int dimension) {
        this.rows = dimension;
        this.columns = dimension;
        this.data = new Double[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (i == j) {
                    this.data[i][j] = 1.0;
                } else {
                    this.data[i][j] = 0.0;
                }
            }
        }
    }
}
