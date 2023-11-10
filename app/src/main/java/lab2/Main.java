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
            System.out.println("13. Add matrices");
            System.out.println("14. Multiply matrix by scalar");
            System.out.println("15. Multiply matrix by matrix");
            System.out.println("16. Transpose matrix");
            System.out.println("17. Create a diagonal matrix");
            System.out.println("18. Create an identity matrix");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");


            int choice = scanner.nextInt();
            int rows;
            int columns;
            int dimension;


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
                    }
                    else {
                        System.out.println("Matrix is not initialized. Create a matrix first.");
                    }
                    break;
                case 9:
                    if (matrix != null) {
                        System.out.print("Enter position: ");
                        columns = scanner.nextInt();
                        System.out.println("Column: " + Arrays.toString(matrix.getColumn(columns)));
                    }
                    else {
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
                    }
                    else {
                        System.out.println("Matrix is not yet initialized.");
                    }
                    break;
                case 13:
                    if (matrix != null && newMatrix != null && matrix.getRows() == newMatrix.getRows() && matrix.getColumns() == newMatrix.getColumns()) {
                        Matrix sum = matrix.add(newMatrix);
                        System.out.println("Result of matrix addition:");
                        sum.printMatrix();
                    }
                    else {
                        System.out.println("Both matrices are not initialized or have different dimensions. Create matrices first.");
                    }
                    break;
                case 14:
                    if (matrix != null) {
                        System.out.print("Enter the scalar value: ");
                        double scalar = scanner.nextDouble();
                        Matrix scaledMatrix = matrix.multiply(scalar);
                        System.out.println("Result of scalar multiplication:");
                        scaledMatrix.printMatrix();
                    }
                    else {
                        System.out.println("Matrix is not yet initialized.");
                    }
                    break;
                case 15:
                    if (matrix != null && newMatrix != null) {
                        if (matrix.getColumns() != newMatrix.getRows()) {
                            System.out.println("Matrix dimensions are not compatible for multiplication.");
                        }
                        else {
                            Matrix result = matrix.multiply(newMatrix);
                            System.out.println("Matrix multiplication result:");
                            result.printMatrix();
                        }
                    }
                    else {
                        System.out.println("Both matrices are not yet initialized.");
                    }
                    break;
                case 16:
                    if (matrix != null) {
                        Matrix transposedMatrix = matrix.transpose();
                        System.out.println("Original Matrix:");
                        matrix.printMatrix();
                        System.out.println("\nTransposed Matrix:");
                        transposedMatrix.printMatrix();
                    }
                    else {
                        System.out.println("Matrix is not yet initialized.");
                    }
                    break;
                case 17:
                    System.out.print("Enter the number of elements in the diagonal vector: ");
                    dimension = scanner.nextInt();
                    Double[] diagonalVector = new Double[dimension];
                   
                    System.out.print("Enter the elements of the diagonal vector: ");
                    for (int i = 0; i < dimension; i++) {
                        diagonalVector[i] = scanner.nextDouble();
                    }
                    matrix = new Matrix(diagonalVector);
                    break;
                case 18:
                    System.out.print("Enter the size of the identity matrix: ");
                    dimension = scanner.nextInt();
                    matrix = new Matrix(dimension);
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
