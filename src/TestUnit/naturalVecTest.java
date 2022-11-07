package TestUnit;

import Api.Vector;
import Departments.naturalVec;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class naturalVecTest {

    Vector<Integer> naturalVec = new naturalVec<>(4);
    naturalVec n = new naturalVec(naturalVec);


    @Test
    void getWorld() {
        Assertions.assertEquals(4, n.getDim());

        Assertions.assertEquals(4, naturalVec.getDim());
    }

    @Test
    void getVecArr() {
        for (int i : n.getVecArr()) {
            assertEquals(i, 0);
        }
    }

    @Test
    void setVecArr() throws Exception {
        Departments.naturalVec zeroVector = new naturalVec(4);
        Departments.naturalVec vec1 = new naturalVec(4);
        boolean testStatus = Arrays.equals(zeroVector.getVecArr(), new Integer []{0,0,0,0});
        assert testStatus;
        Integer[] test = {2, 1, 4, 2};
        vec1.setVecArr( test);
        testStatus = Arrays.equals( vec1.getVecArr(), test);
        assert testStatus;

        assertThrows( Exception.class,()-> vec1.setVecArr(new Integer[]{0,0,0,0,0,0,0}),"cannot change replace vectors with different length");

    }

    @Test
    void getDim() {
        boolean b = naturalVec.getDim() == 4;
        assert (b);
    }

    @Test
    void setDim() {
        naturalVec temp = new naturalVec(3);
        boolean b = temp.getDim() == 3;
        assert b;
        temp.setDim(4);
        b = temp.getDim() == 4;
        assert b;


    }

    @Test
    void sum() throws Exception {
        naturalVec vec1 = new naturalVec(new Integer[]{4, 3, 1, 4});
        naturalVec vec2 = new naturalVec(new Integer[]{2, 2, 0, 2});
        vec2.sum(vec1);
        boolean test = Arrays.equals(new Integer[]{6, 5, 1, 6}, vec2.getVecArr());
        assert test;

        assertThrows( Exception.class,()-> vec1.sum(new naturalVec(new Integer[]{0, 0, 0, 0, 0, 0, 0})),"cannot change replace vectors with different length");
    }

    @Test
    void multiply() {
        naturalVec vec1 = new naturalVec(new Integer[]{4, 3, 1, 4});
        naturalVec vec2 = new naturalVec(new Integer[]{2, 2, 0, 2});

        vec1.multiply(3);
        boolean test = Arrays.equals(new Integer[]{12, 9, 3, 12}, vec1.getVecArr());
        assert test;
    }
}