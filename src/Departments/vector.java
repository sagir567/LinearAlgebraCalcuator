package Departments;

import Api.Vector;

public abstract class vector implements Vector {

    double[] vectorArr = new double[4];
    private int dim = 4;
    private char world ='R';




    @Override
    public Vector sum(Vector v) throws Exception {

        double[] temp = v.getVecArr();
        if (this.dim!=v.getDim())
            throw new RuntimeException("vectors dimension out of bounds, cannot sum vectors from different dimension ");

        for (int i=0;i<this.dim; i++){
            this.vectorArr[i]= temp[i];
        }
        return this;
    }

    @Override
    public Vector multiply(double n) {

        for (int i= 0;i<this.vectorArr.length;i++){
            this.vectorArr[i]*=n;
        }
        return this;
    }

    @Override
    public int getDim() {
        return this.dim;
    }

    @Override
    public double[] getVecArr() {
        return this.vectorArr;
    }

    @Override
    public char getWorld() {
        return this.world;
    }



}

