package Api;

import org.junit.jupiter.api.function.Executable;

public interface Matrix {



    double det ();
    Matrix Transpose();
    int rank();
    Matrix gaussianElimination();
    Matrix multiply(Matrix m)throws Exception;
    Matrix sum(Matrix m)throws Exception;
    Matrix inverse();
    Matrix swapRows(int row1, int row2);
    double[][] getMat();


    Matrix multiply(int row, double a) throws Exception;
    Matrix SumRow(double [] rowA, double[] rowB);
    double[] multiplyRow(int row, double a) throws Exception;

}
