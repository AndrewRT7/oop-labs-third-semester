package lab2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Matrix matrix = null;
        Matrix newMatrix = null;

        while (true) {
            System.out.println("\nMatrix Operations:");
            System.out.println("1. Create an empty matrix");
            System.out.println("2. Create a zero matrix with specified size");
            System.out.println("3. Create a matrix by copying another matrix");
            System.out.println("4. Print matrix");
            System.out.println("5. Fill the matrix with values");
            System.out.println("6. Set element");
            System.out.println("7. Get an element.");
            System.out.println("8. Get a row");
            System.out.println("9. Get a column");
            System.out.println("10. Get matrix dimensions");
            System.out.println("11. Compare matrices");
            System.out.println("12. Generate hash code");
            System.out.println("0. Exit");
            System.out.println("Your choice: ");

            int choice = scanner.nextInt();
            int rows;
            int columns;

            switch (choice) {
                case 1:
                    System.out.print("Enter the number of rows: ");
                    rows = scanner.nextInt();
                    System.out.print("Enter the number of columns: ");
                    columns = scanner.nextInt();
                    matrix = new Matrix(rows, columns);
                    break;
                case 2:
                    System.out.print("Enter the number of rows: ");
                    rows = scanner.nextInt();
                    System.out.print("Enter the number of columns: ");
                    columns = scanner.nextInt();
                    matrix = new Matrix(rows, columns, true);
                    break;
                case 3:
                    if (matrix != null) {
                        newMatrix = new Matrix(matrix.getData());
                        System.out.println("Matrix copied.");
                    }
                    else {
                        System.out.println("Original matrix is not yet initialized.");
                    }
                    break;
                case 4:
                    if (matrix != null) {
                        System.out.println("Original Matrix:");
                        matrix.printMatrix();
                        if (newMatrix != null) {
                        System.out.println("\nCopied Matrix:");
                        newMatrix.printMatrix();
                        }
                    }
                    else {
                        System.out.println("Original matrix is not yet initialized.");
                    }
                    break;
                case 5:
                    if (matrix != null) {
                        System.out.println("Enter values to fill the matrix:");
                        Double[][] values = new Double[matrix.getRows()][matrix.getColumns()];
                        for (int i = 0; i < matrix.getRows(); i++) {
                            for (int j = 0; j < matrix.getColumns(); j++) {
                            values[i][j] = scanner.nextDouble();
                            }
                        }
                        matrix.fillMatrix(values);
                    }
                    else {
                        System.out.println("Matrix is not yet initialized.");
                    }
                    break;
                case 6:
                    if (matrix != null) {
                        System.out.print("Enter the row: ");
                        rows = scanner.nextInt();
                        System.out.print("Enter the column: ");
                        columns = scanner.nextInt();
                        System.out.print("Enter the value: ");
                        Double value = scanner.nextDouble();
                        matrix.setElement(rows, columns, value);
                    }
                    else {
                        System.out.println("Matrix is not yet initialized.");
                    }
                    break;
                case 7:
                    if (matrix != null) {
                        System.out.print("Enter the row: ");
                        rows = scanner.nextInt();
                        System.out.print("Enter the column: ");
                        columns = scanner.nextInt();
                        System.out.println("Element value: " + matrix.getElement(rows, columns));
                    }
                    else {
                        System.out.println("Matrix is not yet initialized.");
                    }
                    break;
                case 8:
                    if (matrix != null) {
                        System.out.print("Enter position: ");
                        rows = scanner.nextInt();
                        System.out.println("Row: " + Arrays.toString(matrix.getRow(rows)));
                    } else {
                        System.out.println("Matrix is not initialized. Create a matrix first.");
                    }
                    break;
                case 9:
                    if (matrix != null) {
                        System.out.print("Enter position: ");
                        columns = scanner.nextInt();
                        System.out.println("Column: " + Arrays.toString(matrix.getColumn(columns)));
                    } else {
                        System.out.println("Matrix is not yet initialized.");
                    }
                    break;
                case 10:
                    if (matrix != null) {
                        int[] dimensions = matrix.getDimensions();
                        System.out.println("Rows: " + dimensions[0]);
                        System.out.println("Columns: " + dimensions[1]);
                    }
                    else {
                        System.out.println("Matrix is not yet initialized.");
                    }
                    break;
                case 11:
                    if (matrix != null && newMatrix != null) {
                        boolean equal = matrix.equals(newMatrix);
                        System.out.println("Matrices are equal: " + equal);
                    }
                    else {
                        System.out.println("Both matrices are not yet initialized.");
                    }
                    break;
                case 12:
                    if (matrix != null) {
                        int code = matrix.hashCode();
                        System.out.println("Hash code for the matrix: " + code);
                    } else {
                        System.out.println("Matrix is not yet initialized.");
                    }
                    break;
                case 0:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
