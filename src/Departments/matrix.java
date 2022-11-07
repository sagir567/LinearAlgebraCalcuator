package Departments;

public class matrix implements Api.Matrix {


    public double[][] getMat() {
        return mat;
    }

    private double[][] mat = new double[3][3];

    public matrix (double [][] mat){
        this.mat = mat;

    }




    @Override
    public double det() {
        return 0;
    }

    @Override
    public Api.Matrix Transpose() {
        return null;
    }

    @Override
    public int rank() {
        return 0;
    }

    @Override
    public Api.Matrix gaussianElimination() {
        return null;
    }

    @Override
    public Api.Matrix multiply(Api.Matrix m) throws Exception {
        return null;
    }

    @Override
    public Api.Matrix sum(Api.Matrix m) throws Exception {
        return null;
    }

    @Override
    public Api.Matrix inverse() {
        return null;
    }

    @Override
    public Api.Matrix swapRows(int row1, int row2) {
    double [] r1 =this.mat[row1];
    this.mat[row1]=this.mat[row2];
    this.mat[row2]=r1;
    return this;
    }

    @Override
    public Api.Matrix multiply(int row, double a) {
        return null;
    }

    @Override
    public Api.Matrix SumRow(double[] rowA, double[] rowB) {
        return null;
    }

    @Override
    public double[] multiplyRow(int row, double a) {
        return new double[0];
    }
}
