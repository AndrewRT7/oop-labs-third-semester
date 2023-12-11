package lab2;

import java.util.Arrays;
import java.util.Scanner;;

public class Main {
    public static void main(String[] args) {



        ImmutableMatrix matrix3 = new ImmutableMatrix(new double[][]{{1, 2, 3}, {4, 0, 6}, {7, 8, 0}});
        System.out.println("\nThird matrix:");
        matrix3.printMatrix();
        ImmutableMatrix[] triangular3 = matrix3.triangularMatrix();
    
        System.out.println("\nUpper triangular matrix:");
        triangular3[0].printMatrix();

        System.out.println("\nLower triangular matrix:");
        triangular3[1].printMatrix();

        Matrix matrix1 = new Matrix(new double[][]{{1, 2, 9}, {4, 7, 8}});
        ImmutableMatrix matrix2 = new ImmutableMatrix(new double[][]{{1, 2, 9, 5, 6}, {4, 7, 8, 2, 3}, {7, 8, 9, 3, 1}});

        ImmutableMatrix copy1 = new ImmutableMatrix(matrix1);
        ImmutableMatrix product = matrix2.multiply(copy1);
        System.out.println("\nUImmutable product:");
        product.printMatrix();

        //ImmutableMatrix ranrow = new ImmutableMatrix(Matrix.randomRowMatrix(4));
        //ranrow.printMatrix();

    //    System.out.println("\nFirst matrix:");
    //    matrix1.printMatrix();
    //    Matrix copy1 = new Matrix(matrix1.getData());
    //    System.out.println("\nCopied matrix:");
    //    copy1.printMatrix();
//
    //    matrix1.setElement(1, 2, 146.);
    //    System.out.println("\nChanged matrix element:");
    //    matrix1.printMatrix();
    //    
    //    System.out.println("\nGetters:");
    //    System.out.println("Element: " + matrix1.getElement(0, 1));
    //    System.out.println("Row: " + Arrays.toString(matrix1.getRow(2)));
    //    System.out.println("Columns: " + Arrays.toString(matrix1.getColumn(1)));
    //    System.out.println(matrix1.getDimension());
//
    //    System.out.println("\nEquals:");
    //    System.out.println(matrix1.equals(copy1));
    //    Matrix copy2 = new Matrix(matrix1.getData());
    //    System.out.println(matrix1.equals(copy2));
//
    //    System.out.println("\nHash code: " + matrix1.hashCode() + ";" + copy1.hashCode() + ";" + copy2.hashCode() + ";");
//
    //    System.out.println("\nSum:");
    //    (matrix1.add(copy2)).printMatrix();
//
    //    System.out.println("\nProduct (scalar):");
    //    (matrix1.multiply(-1)).printMatrix();
//
    //    System.out.println("\nDiagonal matrix:");
    //    Double[] diagonalVector = new Double[4];
    //    System.out.print("Enter the elements of the diagonal vector: ");
    //    for (int i = 0; i < 4; i++) {
    //        diagonalVector[i] = scanner.nextDouble();
    //    }
    //    matrix = new Matrix(diagonalVector);
    //    matrix.printMatrix();
//
    //    System.out.println("\nProduct (matrix):");
    //    (matrix1.multiply(matrix)).printMatrix();
//
    //    System.out.println("\nTransposed matrix:");
    //    matrix1.transpose();
    //    matrix1.printMatrix();
//
    //    System.out.println("\nEnter the number of columns for the randomized row matrix: ");
    //    int randomMatrixColumns = 5;
    //    Matrix randomRowMatrix = Matrix.randomRowMatrix(randomMatrixColumns);
    //    randomRowMatrix.printMatrix();
//
    //    System.out.println("\nEnter the number of rows for the randomized column matrix: ");
    //    int randomMatrixRows = 5;
    //    Matrix randomColumnMatrix = Matrix.randomColumnMatrix(randomMatrixRows);
    //    randomColumnMatrix.printMatrix();
//
    //    Matrix triangle = new Matrix(matrix1.getData());
    //    System.out.println("\nLower triangular matrix: ");
    //    triangle.triangularMatrix();
    //    System.out.println("\nUpper triangular matrix: ");
    //    triangle.printMatrix();

    //   while (true) {
    //       System.out.println("\nMatrix Operations:");
    //       System.out.println("1. Create an empty matrix");
    //       System.out.println("2. Create a zero matrix with specified size");
    //       System.out.println("3. Create a matrix by copying another matrix");
    //       System.out.println("4. Print matrix");
    //       System.out.println("5. Fill the matrix with values");
    //       System.out.println("6. Set element");
    //       System.out.println("7. Get an element.");
    //       System.out.println("8. Get a row");
    //       System.out.println("9. Get a column");
    //       System.out.println("10. Get matrix dimensions");
    //       System.out.println("11. Compare matrices");
    //       System.out.println("12. Generate hash code");
    //       System.out.println("13. Add matrices");
    //       System.out.println("14. Multiply matrix by scalar");
    //       System.out.println("15. Multiply matrix by matrix");
    //       System.out.println("16. Transpose matrix");
    //       System.out.println("17. Create a diagonal matrix");
    //       System.out.println("18. Create an identity matrix");
    //       System.out.println("19. Create row matrix");
    //       System.out.println("20. Create column matrix");
    //       System.out.println("21. Get an upper triangle matrix");
    //       System.out.println("22. Get a lower triangle matrix");
    //       System.out.println("0. Exit");
    //       System.out.print("Your choice: ");

    //    int choice = scanner.nextInt();
    //    int rows;
    //    int columns;
    //    int dimension;

    //    switch (choice) {
    //         case 1:
    //             System.out.print("Enter the number of rows: ");
    //             rows = scanner.nextInt();
    //             System.out.print("Enter the number of columns: ");
    //             columns = scanner.nextInt();
    //             matrix = new Matrix(rows, columns);
    //             break;
    //         case 2:
    //             System.out.print("Enter the number of rows: ");
    //             rows = scanner.nextInt();
    //             System.out.print("Enter the number of columns: ");
    //             columns = scanner.nextInt();
    //             matrix = new Matrix(rows, columns, true);
    //             break;
    //         case 3:
    //             if (matrix != null) {
    //                 newMatrix = new Matrix(matrix.getData());
    //                 System.out.println("Matrix copied.");
    //             }
    //             else {
    //                 System.out.println("Original matrix is not yet initialized.");
    //             }
    //             break;
    //         case 4:
    //             if (matrix != null) {
    //                 System.out.println("Original Matrix:");
    //                 matrix.printMatrix();
    //                 if (newMatrix != null) {
    //                 System.out.println("\nCopied Matrix:");
    //                 newMatrix.printMatrix();
    //                 }
    //             }
    //             else {
    //                 System.out.println("Original matrix is not yet initialized.");
    //             }
    //             break;
    //         case 5:
    //             if (matrix != null) {
    //                 System.out.println("Enter values to fill the matrix:");
    //                 Double[][] values = new Double[matrix.getRows()][matrix.getColumns()];
    //                 for (int i = 0; i < matrix.getRows(); i++) {
    //                     for (int j = 0; j < matrix.getColumns(); j++) {
    //                     values[i][j] = scanner.nextDouble();
    //                     }
    //                 }
    //                 matrix.fillMatrix(values);
    //             }
    //             else {
    //                 System.out.println("Matrix is not yet initialized.");
    //             }
    //             break;
    //         case 6:
    //             if (matrix != null) {
    //                 System.out.print("Enter the row: ");
    //                 rows = scanner.nextInt();
    //                 System.out.print("Enter the column: ");
    //                 columns = scanner.nextInt();
    //                 System.out.print("Enter the value: ");
    //                 Double value = scanner.nextDouble();
    //                 matrix.setElement(rows, columns, value);
    //             }
    //             else {
    //                 System.out.println("Matrix is not yet initialized.");
    //             }
    //             break;
    //         case 7:
    //             if (matrix != null) {
    //                 System.out.print("Enter the row: ");
    //                 rows = scanner.nextInt();
    //                 System.out.print("Enter the column: ");
    //                 columns = scanner.nextInt();
    //                 System.out.println("Element value: " + matrix.getElement(rows, columns));
    //             }
    //             else {
    //                 System.out.println("Matrix is not yet initialized.");
    //             }
    //             break;
    //         case 8:
    //             if (matrix != null) {
    //                 System.out.print("Enter position: ");
    //                 rows = scanner.nextInt();
    //                 System.out.println("Row: " + Arrays.toString(matrix.getRow(rows)));
    //             }
    //             else {
    //                 System.out.println("Matrix is not initialized. Create a matrix first.");
    //             }
    //             break;
    //         case 9:
    //             if (matrix != null) {
    //                 System.out.print("Enter position: ");
    //                 columns = scanner.nextInt();
    //                 System.out.println("Column: " + Arrays.toString(matrix.getColumn(columns)));
    //             }
    //             else {
    //                 System.out.println("Matrix is not yet initialized.");
    //             }
    //             break;
    //         case 10:
    //             if (matrix != null) {
    //                 int[] dimensions = matrix.getDimensions();
    //                 System.out.println("Rows: " + dimensions[0]);
    //                 System.out.println("Columns: " + dimensions[1]);
    //             }
    //             else {
    //                 System.out.println("Matrix is not yet initialized.");
    //             }
    //             break;
    //         case 11:
    //             if (matrix != null && newMatrix != null) {
    //                 boolean equal = matrix.equals(newMatrix);
    //                 System.out.println("Matrices are equal: " + equal);
    //             }
    //             else {
    //                 System.out.println("Both matrices are not yet initialized.");
    //             }
    //             break;
    //         case 12:
    //             if (matrix != null) {
    //                 int code = matrix.hashCode();
    //                 System.out.println("Hash code for the matrix: " + code);
    //             }
    //             else {
    //                 System.out.println("Matrix is not yet initialized.");
    //             }
    //             break;
    //         case 13:
    //             if (matrix != null && newMatrix != null && matrix.getRows() == newMatrix.getRows() && matrix.getColumns() == newMatrix.getColumns()) {
    //                 Matrix sum = matrix.add(newMatrix);
    //                 System.out.println("Result of matrix addition:");
    //                 sum.printMatrix();
    //             }
    //             else {
    //                 System.out.println("Both matrices are not initialized or have different dimensions. Create matrices first.");
    //             }
    //             break;
    //         case 14:
    //             if (matrix != null) {
    //                 System.out.print("Enter the scalar value: ");
    //                 double scalar = scanner.nextDouble();
    //                 Matrix scaledMatrix = matrix.multiply(scalar);
    //                 System.out.println("Result of scalar multiplication:");
    //                 scaledMatrix.printMatrix();
    //             }
    //             else {
    //                 System.out.println("Matrix is not yet initialized.");
    //             }
    //             break;
    //         case 15:
    //             if (matrix != null && newMatrix != null) {
    //                 if (matrix.getColumns() != newMatrix.getRows()) {
    //                     System.out.println("Matrix dimensions are not compatible for multiplication.");
    //                 }
    //                 else {
    //                     Matrix result = matrix.multiply(newMatrix);
    //                     System.out.println("Matrix multiplication result:");
    //                     result.printMatrix();
    //                 }
    //             }
    //             else {
    //                 System.out.println("Both matrices are not yet initialized.");
    //             }
    //             break;
    //         case 16:
    //             if (matrix != null) {
    //                 System.out.println("Original Matrix:");
    //                 matrix.printMatrix();
    //                 matrix.transpose();
    //                 System.out.println("\nTransposed Matrix:");
    //                 matrix.printMatrix();
    //             }
    //             else {
    //                 System.out.println("Matrix is not yet initialized.");
    //             }
    //             break;
    //         case 17:
    //             System.out.print("Enter the number of elements in the diagonal vector: ");
    //             dimension = scanner.nextInt();
    //             Double[] diagonalVector = new Double[dimension];
    //             
    //             System.out.print("Enter the elements of the diagonal vector: ");
    //             for (int i = 0; i < dimension; i++) {
    //                 diagonalVector[i] = scanner.nextDouble();
    //             }
    //             matrix = new Matrix(diagonalVector);
    //             break;
    //         case 18:
    //             System.out.print("Enter the size of the identity matrix: ");
    //             dimension = scanner.nextInt();
    //             matrix = new Matrix(dimension);
    //             break;
    //         case 19:
    //             System.out.print("Enter the number of columns for the randomized row matrix: ");
    //             int randomMatrixColumns = scanner.nextInt();
    //             Matrix randomRowMatrix = Matrix.randomRowMatrix(randomMatrixColumns);
    //             matrix = randomRowMatrix;
    //             break;
    //         case 20:
    //             System.out.print("Enter the number of rows for the randomized column matrix: ");
    //             int randomMatrixRows = scanner.nextInt();
    //             Matrix randomColumnMatrix = Matrix.randomColumnMatrix(randomMatrixRows);
    //             matrix = randomColumnMatrix;
    //             break;
    //         case 21:
    //             if (matrix != null) {
    //                 System.out.println("Original Matrix:");
    //                 matrix.printMatrix();
    //                 matrix.upperTriangular();
    //                 System.out.println("\nMatrix converted to upper triangular form:");
    //                 matrix.printMatrix();
    //             }
    //             else {
    //                 System.out.println("Matrix is not yet initialized.");
    //             }
    //             break;
    //         case 22:
    //             if (matrix != null) {
    //                 System.out.println("Original Matrix:");
    //                 matrix.printMatrix();
    //                 matrix.lowerTriangular();
    //                 System.out.println("\nMatrix converted to lower triangular form:");
    //                 matrix.printMatrix();
    //             }
    //             else {
    //                 System.out.println("Matrix is not yet initialized.");
    //             }
    //             break;
    //         case 0:
    //             scanner.close();
    //             System.exit(0);
    //         default:
    //             System.out.println("Invalid choice. Please try again.");
    //     }
    // }
  }
}