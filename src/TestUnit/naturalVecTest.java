package TestUnit;

import Api.vec;
import Departments.naturalVec;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class naturalVecTest {

    vec<Integer> naturalVec = new naturalVec<>(4);
    naturalVec n = new naturalVec( naturalVec);
    Departments.naturalVec emptyNvec = new naturalVec(2);

    @Test
    void getWorld() {
        Assertions.assertEquals(4 , n.getDim());

        Assertions.assertEquals(4 , naturalVec.getDim());
    }

    @Test
    void getVecArr() {
        for (int i:n.getVecArr()){
            assertEquals(i, 0);
        }



    }

    @Test
    void setVecArr() {
        for (int i:n.getVecArr()){
            assertEquals(i, 0);
        }
        int[] test ={2,1,4,2,2};
        n.setVecArr(test);
        for (int i=0;i<n.getDim();i++){
            Assertions.assertEquals(n.getVecArr()[i],test[i] );
        }

    }

    @Test
    void getDim() {
    }

    @Test
    void setDim() {
    }

    @Test
    void sum() {
    }

    @Test
    void multiply() {
    }
}