package Api;

import Departments.matrix;

public interface Matrix {



    double det ();
    Matrix Transpose();
    int rank();
    Matrix gaussianElimination();
    Matrix multiply(Matrix m)throws Exception;
    Matrix sum(Matrix m)throws Exception;
    Matrix inverse();
    Matrix swapRows(int row1, int row2);


    Matrix multiply(int row, double a);
    Matrix SumRow(double [] rowA, double[] rowB);
    double [] multiplyRow(int row,double a);

}
