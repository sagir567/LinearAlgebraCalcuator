package TestUnit;

import Departments.matrix;
import org.junit.jupiter.api.Test;

import javax.management.RuntimeErrorException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class matrixTest {

    double [][] arr1={{1,2,3},
                      {4,5,6},
                       {7,8,9}};
    matrix mat1 = new matrix(arr1);
    double [][]naturalArr = {{1,0,0},
                              {0,1,0},
                             {0,0,1}};

    matrix naturlMat = new matrix( naturalArr);

    double [][]arr2 =  {{0,-1,4,0},
                        {1,-5,1,1},
                        {-1,-1,8,-5}};

    matrix mat2 = new matrix( arr2);


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
       mat2.gaussianElimination();
    }

    @Test
    void multiply() {
    }

    @Test
    void sum() throws Exception {
        double [][]res = {{2,2,3},
                         {4,6,6},
                        {7,8,10}};
         assertArrayEquals(res,mat1.sum(naturlMat).getMat());

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
    void multiplyRow() throws Exception {
        double [][] excepted ={{1,2,3},
                               {4,5,6},
                               {42,48,54}};
        mat1.multiplyRow(2, 6);
        assertArrayEquals(excepted, mat1.getMat());
        assertThrows(Exception.class,()->mat1.multiplyRow(2 ,0), "multiply mat row or colum by zero is illegal ");

        assertArrayEquals(excepted, mat1.getMat());


    }




    @Test
    void getMat() {
    }



    @Test
    void testToString() {
        String s =naturlMat.toString();
        System.out.println(s);

    }
}