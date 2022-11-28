package Departments;

import Api.Vector;

public class polinom extends vector {

    double[] vectorArr = new double[4];
    private int dim = 4;
    private char world = 'R';


    public polinom(String p) {
        int tempRank = 0;
        this.dim = 0;
        String clone = p;
        for (int i = 0; i < clone.length(); i++) {
            if (p.charAt(i) == '^') {
                tempRank = Integer.parseInt(java.lang.String.valueOf(clone.charAt(i + 1)));
                if (tempRank > this.dim) {
                    this.dim = tempRank;
                }
            }
        }
        this.vectorArr = new double[this.dim + 1];
        int current = 0;
        for (int i = 0; i < clone.length(); i++) {
            if (clone.charAt(i) == '^') {
                current = Integer.parseInt(java.lang.String.valueOf(clone.charAt(i + 1)));
                this.vectorArr[current] = Double.parseDouble(clone.substring(i - 5, i - 1));

            }
            // 3.1X^2.3x-1.1
            if (i == clone.length() - 1 && clone.charAt(i - 1) != '^') {
                this.vectorArr[0] = Double.parseDouble(clone.substring(Math.max(clone.lastIndexOf("-" + 1), clone.lastIndexOf("+" + 1))));


            }
        }


    }


    public Vector sum(Vector v) throws Exception {
        super.sum(v);
        return v;
    }

    @Override
    public Vector multiply(double n) {
        super.multiply(n);
        return this;
    }

    public Vector mul(Vector v) {
        double[] temp = v.getVecArr();
        double[] result = new double[(this.vectorArr.length + v.getVecArr().length) - 1];

        for (int i = 0; i < result.length; i++) {
            result[i] = 0;
        }
        for (int i = 0; i < this.vectorArr.length; i++) {
            for (int j = 0; j < this.vectorArr.length; j++) {
                result[i + j] = this.vectorArr[i] * temp[j];
            }
        }
        this.vectorArr = result;
        this.dim = result.length;
        return this;

    }

    public double[] derivative() {
        double[] result = new double[this.vectorArr.length - 1];

        for (int i = 0; i < result.length; i++) {
            result[i] = (this.vectorArr[i + 1] * (i + 1));

        }
        this.vectorArr = result;
        this.dim--;
        return this.vectorArr;


    }

    public String toString() {
        String result = "";
        for (int i = this.vectorArr.length - 1; i >= 0; i--) {
            if (i != 0) {
                result += (this.vectorArr[i] < 0) ? this.vectorArr[i] + "x^" + i : "+" + this.vectorArr[i] + "x^" + i;
            } else {
                result += (this.vectorArr[i] < 0) ? this.vectorArr[i] : "+" + this.vectorArr[i];
            }
        }
        System.out.println(result);
        return result;
    }


    public double calcForX(double x) {
        double result = 0;
        for (int i = this.vectorArr.length - 1; i >= 0; i--) {
            if (i != 0) {
                result += this.vectorArr[i] * Math.pow(x, i);
            } else {
                result += this.vectorArr[i];
            }
        }
        return result;

    }


}
