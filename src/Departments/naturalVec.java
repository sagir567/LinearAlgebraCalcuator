package Departments;

import Api.Vector;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class naturalVec<Integer> implements Vector<java.lang.Integer> {


    private java.lang.Integer[] VecArr;
    private int dim = 2;
    private char world;


    public naturalVec(java.lang.Integer[] v) {
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
            Exception e = new RuntimeException("Api.realVec v is not natural, cannot creat natural vector from different type");
            System.out.println(e);
            return;
        } else {
            this.world = v.getWorld();
            this.VecArr = new java.lang.Integer[v.getDim()];
            this.dim = v.getDim();
            naturalVec temp = (naturalVec) v;
            for (int i = 0; i < temp.getDim(); i++) {
                this.VecArr[i] = ((naturalVec) v).getVecArr()[i];
            }

        }
    }

    public naturalVec(int n) {
        this.VecArr = new java.lang.Integer[n];
        for(int i=0;i<n;i++)this.VecArr[i]=0;
        this.dim = n;
        this.world = 'N';

    }

    public char getWorld() {
        return this.world;
    }


    public java.lang.Integer[] getVecArr() {
        java.lang.Integer[] temp = new java.lang.Integer[this.VecArr.length];
        java.lang.Integer[] source = this.VecArr;
        for(int i=0;i<this.VecArr.length;i++){
            temp[i]=source[i];
        }
        return temp;
    }

    public void setVecArr(java.lang.Integer[] vecArr) throws Exception {
        if (this.VecArr.length != vecArr.length) throw new Exception("cannot replace vectors with different length");

        java.lang.Integer[] deepCopy = Arrays.copyOf(vecArr, this.getVecArr().length);

        this.VecArr = deepCopy;
    }

    public int getDim() {
        return dim;
    }

    public void setDim(int dim) {
        this.dim = dim;
    }


    @Override
    public void sum(@NotNull Vector v) throws Exception {
        naturalVec temp = (naturalVec) v;
        if (v.getWorld() != 'N') throw new Exception("cannot sum vectors from different worlds");
        if (temp.getVecArr().length != this.VecArr.length)
            throw new Exception("cannot sum vectors from different dimension ");


        java.lang.Integer[] tempArr = temp.VecArr;

        for (int i = 0; i < this.dim; i++) {
            this.VecArr[i] += tempArr[i];
        }
    }

    @Override
    public void multiply(java.lang.Integer n) {
        int num = n;
        for (int i = 0; i < this.dim; i++) {
            this.VecArr[i] *= num;
        }
        System.out.println("multiplication succeeded ");
    }


}



