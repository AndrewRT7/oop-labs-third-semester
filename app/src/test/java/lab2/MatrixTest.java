package lab2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @Test
    void testMatrixInitialization() {
        Matrix matrix = new Matrix(3, 4);
        assertEquals(3, matrix.getRows());
        assertEquals(4, matrix.getColumns());
    }

    @Test
    void testEmptyMatrixInitialization() {
        int rows = 3;
        int columns = 4;
        Matrix matrix = new Matrix(rows, columns);
        assertEquals(rows, matrix.getRows());
        assertEquals(columns, matrix.getColumns());
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                assertNull(matrix.getElement(i, j));
            }
        }
    }

    @Test
    void testMatrixEquality() {
        Double[][] data1 = {{1.0, 2.0}, {3.0, 4.0}};
        Double[][] data2 = {{1.0, 2.0}, {3.0, 4.0}};
        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);
        assertEquals(matrix1, matrix2);
    }

    @Test
    void testMatrixAddition() {
        Double[][] data1 = {{1.0, 2.0}, {3.0, 4.0}};
        Double[][] data2 = {{5.0, 6.0}, {7.0, 8.0}};
        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);
        Matrix result = matrix1.add(matrix2);
        Double[][] expected = {{6.0, 8.0}, {10.0, 12.0}};
        assertArrayEquals(expected, result.getData());
    }

    @Test
    void testMatrixScalarMultiplication() {
        Double[][] data = {{1.0, 2.0}, {3.0, 4.0}};
        Matrix matrix = new Matrix(data);
        Matrix result = matrix.multiply(2.0);
        Double[][] expected = {{2.0, 4.0}, {6.0, 8.0}};
        assertArrayEquals(expected, result.getData());
    }

    @Test
    void testMatrixMultiplication() {
        Double[][] data1 = {{1.0, 2.0}, {3.0, 4.0}};
        Double[][] data2 = {{5.0, 6.0}, {7.0, 8.0}};
        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);
        Matrix result = matrix1.multiply(matrix2);
        Double[][] expected = {{19.0, 22.0}, {43.0, 50.0}};
        assertArrayEquals(expected, result.getData());
    }

    @Test
    void testMatrixTranspose() {
        Double[][] data = {{1.0, 2.0}, {3.0, 4.0}, {5.0, 6.0}};
        Matrix matrix = new Matrix(data);
        matrix.transpose();
        Double[][] expected = {{1.0, 3.0, 5.0}, {2.0, 4.0, 6.0}};
        assertArrayEquals(expected, matrix.getData());
    }
}
