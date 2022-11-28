package Departments;

import Api.Vector;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class naturalVec extends vector {


    private double[] VecArr;
    private int dim = 2;
    private char world;


    public naturalVec(double[] v) {
        this.VecArr = v;
        this.dim = v.length;

        this.world = 'N';

    }

    public naturalVec(naturalVec vec) {


        this.world = 'N';
        for (int i = 0; i < vec.getDim(); i++) {
            this.VecArr[i] =  vec.getVecArr()[i];
        }
        this.dim = vec.getDim();

    }

    public naturalVec(Vector v) {
        if (v.getWorld() != 'N') {
            Exception e = new RuntimeException("Api.vector v is not natural, cannot creat natural vector from different type");
            System.out.println(e);
            return;
        } else {
            this.world = v.getWorld();
            this.VecArr = new double[v.getDim()];
            this.dim = v.getDim();
            naturalVec temp = (naturalVec) v;
            for (int i = 0; i < temp.getDim(); i++) {
                this.VecArr[i] = ((naturalVec) v).getVecArr()[i];
            }

        }
    }

    public naturalVec(int n) {
        this.VecArr = new double[n];
        for(int i=0;i<n;i++)this.VecArr[i]=0;
        this.dim = n;
        this.world = 'N';


    }

    public char getWorld() {
        return this.world;
    }


    public double[] getVecArr() {
        double[] temp = new double[this.VecArr.length];
        double[] source = this.VecArr;
        for(int i=0;i<this.VecArr.length;i++){
            temp[i]=source[i];
        }
        return temp;
    }

    public void setVecArr(double[] vecArr) throws Exception {
        if (this.VecArr.length != vecArr.length) throw new Exception("cannot replace vectors with different length");

        double[] deepCopy = Arrays.copyOf(vecArr, this.getVecArr().length);

        this.VecArr = deepCopy;
    }


    public int getDim() {
        return dim;
    }

    public void setDim(int dim) {
        this.dim = dim;
    }


    @Override
    public Vector sum(@NotNull Vector v) throws Exception {
        naturalVec temp = (naturalVec) v;
        if (v.getWorld() != 'N') throw new Exception("cannot sum vectors from different worlds");
        if (temp.getVecArr().length != this.VecArr.length)
            throw new Exception("cannot sum vectors from different dimension ");


        double[] tempArr = temp.VecArr;

        for (int i = 0; i < this.dim; i++) {
            this.VecArr[i] += tempArr[i];
        }
        return v;
    }




    @Override
    public Vector multiply(double n) {
        double num = n;
        for (int i = 0; i < this.dim; i++) {
            this.VecArr[i] *= num;
        }
        System.out.println("multiplication succeeded ");
        return this;
    }


}



