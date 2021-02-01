package cz.educanet.tranformations;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class MatrixTest {

    private IMatrix a;
    private IMatrix b;
    private IMatrix c;
    private IMatrix d;
    private IMatrix empty;

    @Before
    public void setUp() throws Exception {
        double[][] rawA = {
                {1, 1, 1},
                {1, 1, 1},
        };
        a = MatrixFactory.create(rawA);

        double[][] rawB = {
                {1, 1, 1},
                {1, 1, 1},
                {0, 0, 0},
        };
        b = MatrixFactory.create(rawB);
        double[][] rawC = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1},
        };
        c = MatrixFactory.create(rawC);

        double[][] rawEmpty = {};
        empty = MatrixFactory.create(rawEmpty);

        double[][] rawD = {
                {1, 1}
        };
        d = MatrixFactory.create(rawD);
    }

    @Test
    public void getRows() {
        assertEquals(2, a.getRows());
        assertEquals(3, b.getRows());
        assertEquals(3, c.getRows());
        assertEquals(0, empty.getRows());
    }

    @Test
    public void getColumns() {
        assertEquals(3, a.getColumns());
        assertEquals(3, b.getColumns());
        assertEquals(3, c.getColumns());
        assertEquals(0, empty.getColumns());
        assertEquals(2, d.getColumns());
    }

    @Test
    public void times() {
        IMatrix mat = a.times(b);
        assertEquals(2, mat.getRows());
        assertEquals(3, mat.getColumns());
        for (int y = 0; y < mat.getRows(); y++){
            for (int x = 0; x < mat.getColumns(); x++){
                assertEquals(2.0, mat.get(y, x), 0.01);
            }
        }
    }

    @Test
    public void timesScalar() {
        IMatrix mat = a.times(7);
        assertEquals(2, mat.getRows());
        assertEquals(3, mat.getColumns());
        for (int y = 0; y < mat.getRows(); y++){
            for (int x = 0; x < mat.getColumns(); x++){
                assertEquals(7.0, mat.get(y, x), 0.01);
            }
        }
    }

    @Test
    public void add() {
        IMatrix mat = b.add(c);
        double[][] res = {
                {2, 1, 1},
                {1, 2, 1},
                {0, 0, 1}
        };
        assertEquals(3, mat.getRows());
        assertEquals(3, mat.getColumns());
        for (int y = 0; y < mat.getRows(); y++){
            for (int x = 0; x < mat.getColumns(); x++){
                assertEquals(res[y][x], mat.get(y, x), 0.01);
            }
        }
    }

    @Test
    public void get() {
        assertEquals(1.0, d.get(0, 0), 0.01);
    }

    @Test
    public void transpose() {
    }

    @Test
    public void determinant() {
    }
}
