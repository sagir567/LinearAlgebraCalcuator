package Departments;

import Api.vec;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class naturalVec<Integer> implements vec {


    private int[] VecArr;
    private int dim = 2;
    private char world;


    public naturalVec(int[] v) {
        this.VecArr = v;
        this.dim = v.length;

        this.world = 'N';

    }

    public naturalVec(naturalVec vec) {


        this.world = 'N';
        for (int i = 0; i < vec.getDim(); i++) {
            this.VecArr[i] = (int) vec.getVecArr()[i];
        }
        this.dim = vec.getDim();

    }

    public naturalVec(vec v) {
        if (v.getWorld() != 'N') {
            Exception e = new Exception("Api.vec v is not natural, cannot creat natural vector from different type");
            System.out.println(e);
            return;
        } else {
            this.world = v.getWorld();
            this.VecArr = new int[v.getDim()];
            this.dim = v.getDim();
            naturalVec temp = (naturalVec) v;
            for (int i = 0; i < temp.getDim(); i++) {
                this.VecArr[i] = ((naturalVec) v).getVecArr()[i];
            }

        }
    }

    public naturalVec(int n) {
        this.VecArr = new int[n];
        this.dim = n;
        this.world = 'N';

    }

    public char getWorld() {
        return this.world;
    }


    public int[] getVecArr() {
        return this.VecArr;
    }

    public void setVecArr(int[] vecArr) throws Exception {
        if (this.VecArr.length != vecArr.length) throw new Exception("cannot replace vectors with different length");

        int[] deepCopy = Arrays.copyOf(vecArr, this.getVecArr().length);

        VecArr = vecArr;
    }

    public int getDim() {
        return dim;
    }

    public void setDim(int dim) {
        this.dim = dim;
    }


    @Override
    public void sum(@NotNull vec v) throws Exception {
        naturalVec temp = (naturalVec) v;
        if (v.getWorld() != 'N') throw new Exception("cannot sum vectors from different worlds");
        if (temp.getVecArr().length != this.VecArr.length)
            throw new Exception("cannot sum vectors from different dimension ");


        int[] tempArr = temp.VecArr;

        for (int i = 0; i < this.dim; i++) {
            this.VecArr[i] += tempArr[i];
        }
    }

    @Override
    public void multiply(int n) {


        for (int i = 0; i < this.dim; i++) {
            this.VecArr[i] *= n;
        }
        System.out.println("multiplication succeeded ");
    }
}



