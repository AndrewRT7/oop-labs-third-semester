package lab2;

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

    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(data[i][j] + "\t");
            }
            System.out.println();
        }
    }
}