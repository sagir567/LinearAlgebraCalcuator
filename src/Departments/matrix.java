package Departments;

import org.junit.jupiter.api.function.Executable;

public class matrix implements Api.Matrix {


    private int rank;
    private boolean singular;
    private int det;

    public double[][] getMat() {
        return mat;
    }

    private double[][] mat = new double[3][3];

    public matrix(double[][] mat) {
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


    private void backSub() {
        double x[]
                = new double[this.mat.length]; // An array to store solution

    /* Start calculating from last equation up to the
           first */
        for (int i = this.mat.length - 1; i >= 0; i--) {

            /* start with the RHS of the equation */
            x[i] = mat[i][this.mat[i].length - 1];

      /* Initialize j to i+1 since matrix is upper
               triangular*/
            for (int j = i + 1; j < this.mat.length; j++) {

                /* subtract all the lhs values
                 * except the coefficient of the variable
                 * whose value is being calculated */
                x[i] -= mat[i][j] * x[j];
            }

      /* divide the RHS by the coefficient of the
               unknown being calculated */
            x[i] = x[i] / mat[i][i];
        }

        System.out.println();
        System.out.println("Solution for the system:");
        for (int i = 0; i < this.mat.length; i++) {
            System.out.format("x" + i + " =%.6f", x[i]);
            System.out.println();
        }
    }

    private int forwardElimnation() {
        for (int k = 0; k < this.mat.length; k++) {

            // Initialize maximum value and index for pivot
            int i_max = k;
            int v_max = (int) this.mat[i_max][k];

            /* find greater amplitude for pivot if any */
            for (int i = k + 1; i < this.mat.length; i++)
                if (Math.abs(this.mat[i][k]) > v_max) {
                    v_max = (int) this.mat[i][k];
                    i_max = i;
                }

            /* if a principal diagonal element  is zero,
             * it denotes that matrix is singular, and
             * will lead to a division-by-zero later. */
            if (this.mat[k][i_max] == 0) {
                System.out.println("mat is singular");
                return k;
            }

            /* Swap the greatest value row with current row
             */
            if (i_max != k) swapRows(k, i_max);

            for (int i = k + 1; i < this.mat.length; i++) {

                /* factor f to set current row kth element
                 * to 0, and subsequently remaining kth
                 * column to 0 */
                double f = this.mat[i][k] / this.mat[k][k];

        /* subtract fth multiple of corresponding
                   kth row element*/
                for (int j = k + 1; j < this.mat[k].length; j++)
                    this.mat[i][j] -= this.mat[k][j] * f;

                /* filling lower triangular matrix with
                 * zeros*/
                this.mat[i][k] = 0;
            }
        }
        this.toString();
        return -1;


    }


    @Override
    public Api.Matrix gaussianElimination() {
        int matStatus = forwardElimnation();
        if (matStatus != -1) {
            System.out.println("Mat is singular");
            this.singular = true;
            this.det = 0;

            if (this.mat[matStatus][this.mat.length] != 0) {
                System.out.println("inConsistent System");

            } else System.out.println("system may have infinitely many solutions");
            return this;
        }

        backSub();
        return this;
    }


    @Override
    public Api.Matrix multiply(Api.Matrix m) throws Exception {
        return null;
    }

    @Override
    public Api.Matrix sum(Api.Matrix m) throws Exception {
        for (int i = 0; i < this.mat.length; i++) {
            for (int j = 0; j < this.mat[i].length; j++) {
                this.mat[i][j] += m.getMat()[i][j];
            }
        }
        return this;
    }

    @Override
    public Api.Matrix inverse() {
        return null;
    }

    @Override
    public Api.Matrix swapRows(int row1, int row2) {
        double[] r1 = this.mat[row1];
        this.mat[row1] = this.mat[row2];
        this.mat[row2] = r1;
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
    public double[] multiplyRow(int row, double a) throws Exception {
        if (a == 0) throw new Exception("multiply mat row or colum by zero is illegal ");

        for (int i = 0; i < this.mat[row].length; i++) {
            this.mat[row][i] = a * this.mat[row][i];
        }
        return this.mat[row];
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < this.mat.length; i++, System.out.println("|")) {
            s += "|";
            System.out.print("|");
            for (int j = 0; j < this.mat[i].length; j++) {
                System.out.print(mat[i][j] + ",");
                s += mat[i][j];
                s += ",";
            }
            s += "|\n";

        }
        System.out.println("");
        return s;
    }
}
