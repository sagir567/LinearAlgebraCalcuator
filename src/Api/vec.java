package Api;

import java.sql.Array;

public interface vec<T> {




    public void sum (vec v) throws Exception; // return the sum of the different vectors
//    public void multiply(T n); // multiply the current Departments.naturalVec with the given input
    public int getDim();// return the dimension of the vector
//    public Array[] getVecArr();// return an array who represents the Api.vec
    public char getWorld();

    void multiply(int n);
}
