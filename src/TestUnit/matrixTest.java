package TestUnit;

import Departments.matrix;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class matrixTest {

    double [][] arr1={{1,2,3},
                      {4,5,6},
                       {7,8,9}};
    matrix mat1 = new matrix(arr1);


    @Test
    void det() {
    }

    @Test
    void transpose() {
    }

    @Test
    void rank() {
    }

    @Test
    void gaussianElimination() {
    }

    @Test
    void multiply() {
    }

    @Test
    void sum() {
    }

    @Test
    void inverse() {
    }

    @Test
    void swapRows() {
        for (int i=0;i<arr1.length;i++){
            System.out.println(Arrays.toString(arr1[i]));
            System.out.println();
        }
        mat1.swapRows(1, 2);

        arr1 = mat1.getMat();
        for (int i=0;i<arr1.length;i++){
            System.out.println(Arrays.toString(arr1[i]));
            System.out.println();
        }

    }

    @Test
    void testMultiply() {
    }

    @Test
    void sumRow() {
    }

    @Test
    void multiplyRow() {
    }
}