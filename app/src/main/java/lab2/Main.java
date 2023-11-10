package lab2;

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
                        System.out.println("Copied Matrix:");
                        newMatrix.printMatrix();
                        }
                    }
                    else {
                        System.out.println("Original matrix is not initialized. Create a matrix first.");
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