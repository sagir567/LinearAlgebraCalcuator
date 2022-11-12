package Departments;

import Api.Vector;

public class realVec implements Vector<Double> {

    private  Double [] vectorArr = new Double[4];
    private int dim = 4;
    private char world ='R';




    @Override
    public void sum(Vector v) throws Exception {

        Double [] temp = (Double[]) v.getVecArr();
        if (this.dim!=v.getDim())
            throw new RuntimeException("vectors dimension out of bounds, cannot sum vectors from different dimension ");

        for (int i=0;i<this.dim; i++){
            this.vectorArr[i]= temp[i];
        }
    }

    @Override
    public void multiply(Double n) {

        for (int i= 0;i<this.vectorArr.length;i++){
            this.vectorArr[i]*=n;
        }
    }

    @Override
    public int getDim() {
        return this.dim;
    }

    @Override
    public Double[] getVecArr() {
        return this.vectorArr;
    }

    @Override
    public char getWorld() {
        return this.world;
    }


}
