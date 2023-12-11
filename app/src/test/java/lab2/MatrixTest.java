package lab2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MatrixTest {

    @Test
    public void testMatrixConstructorAndGetters() {
        Matrix matrix = new Matrix(3, 3);
        assertEquals("Rows: 3, Columns: 3", matrix.getDimension());
        assertEquals(3, matrix.getRows());
        assertEquals(3, matrix.getColumns());
    }

    @Test
    public void testSetElementAndGetElement() {
        Matrix matrix = new Matrix(2, 2);
        matrix.setElement(0, 0, 5.0);
        matrix.setElement(1, 1, 8.0);
        assertEquals(5.0, matrix.getElement(0, 0), 0.0001);
        assertEquals(8.0, matrix.getElement(1, 1), 0.0001);
    }

    @Test
    public void testAdd() {
        Matrix matrix1 = new Matrix(new double[][]{{1, 2}, {3, 4}});
        Matrix matrix2 = new Matrix(new double[][]{{5, 6}, {7, 8}});
        Matrix expected = new Matrix(new double[][]{{6, 8}, {10, 12}});
        assertEquals(expected, matrix1.add(matrix2));
    }

    @Test
    public void testMultiplyScalar() {
        Matrix matrix = new Matrix(new double[][]{{1, 2}, {3, 4}});
        Matrix expected = new Matrix(new double[][]{{2, 4}, {6, 8}});
        assertEquals(expected, matrix.multiply(2));
    }

    @Test
    public void testMultiplyMatrix() {
        Matrix matrix1 = new Matrix(new double[][]{{1, 2}, {3, 4}});
        Matrix matrix2 = new Matrix(new double[][]{{5, 6}, {7, 8}});
        Matrix expected = new Matrix(new double[][]{{19, 22}, {43, 50}});
        assertEquals(expected, matrix1.multiply(matrix2));
    }

    @Test
    public void testTranspose() {
        Matrix matrix = new Matrix(new double[][]{{1, 2}, {3, 4}, {5, 6}});
        Matrix expected = new Matrix(new double[][]{{1, 3, 5}, {2, 4, 6}});
        assertEquals(expected, matrix.transpose());
    }

    @Test
    public void testDiagonalMatrix() {
        double[] diagonal = {1, 2, 3};
        Matrix expected = new Matrix(new double[][]{{1, 0, 0}, {0, 2, 0}, {0, 0, 3}});
        assertEquals(expected, new Matrix().diagonalMatrix(diagonal));
    }

    @Test
    public void testIdentityMatrix() {
        Matrix expected = new Matrix(new double[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}});
        assertEquals(expected, new Matrix().identityMatrix(3));
    }
}
