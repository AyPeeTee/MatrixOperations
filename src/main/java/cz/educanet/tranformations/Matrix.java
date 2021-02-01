package cz.educanet.tranformations;

import kotlin.NotImplementedError;

import java.util.Arrays;

public class Matrix implements IMatrix {

    private final double[][] rawArray;

    public Matrix(double[][] rawArray) {
        this.rawArray = rawArray;
    }

    @Override
    public int getRows() {
        return rawArray.length;
    }

    @Override
    public int getColumns() {
        if (getRows() > 0)
            return rawArray[0].length;

        return 0;
    }

    @Override
    public IMatrix times(IMatrix matrix) {
        double[][] mat = new double[this.getRows()][matrix.getColumns()];
        for (int y = 0; y < this.getRows(); y++){
            for (int x = 0; x < matrix.getColumns(); x++){
                mat[y][x] = 0.0;
                for (int i = 0; i < this.getColumns(); i++){
                    mat[y][x] += this.get(y, i) * matrix.get(i, x);
                }
            }
        }
        return new Matrix(mat);
    }
    @Override
    public IMatrix times(Number scalar) {
        double[][] mat = new double[this.getRows()][this.getColumns()];
        for (int y = 0; y < this.getRows(); y++){
            for (int x = 0; x < this.getColumns(); x++){
                mat[y][x] = this.get(y, x) * scalar.doubleValue();
            }
        }
        return new Matrix(mat);
    }

    @Override
    public IMatrix add(IMatrix matrix) {
        double[][] mat = new double[this.getRows()][this.getColumns()];
        for (int y = 0; y < this.getRows(); y++){
            for (int x = 0; x < this.getColumns(); x++){
                mat[y][x] = this.get(y, x) + matrix.get(y, x);
            }
        }
        return new Matrix(mat);
    }

    @Override
    public double get(int n, int m) {
        return this.rawArray[n][m];
    }

    //region Optional
    @Override
    public IMatrix transpose() {
        return null;
    }

    @Override
    public double determinant() {
        return 0;
    }
    //endregion
    //region Generated
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return Arrays.equals(rawArray, matrix.rawArray);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(rawArray);
    }
    //endregion
}
