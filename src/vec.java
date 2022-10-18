import java.lang.reflect.Array;

public interface vec<T> {




    public void sum (vec v); // return the sum of the different vectors
//    public void multiply(T n); // multiply the current naturalVec with the given input
    public int getDim();// return the dimension of the vector
//    public Array[] getVecArr();// return an array who represents the vec
    public char getWorld();

    void multiply(int n);
}
