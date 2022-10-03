public class vector {

    private double [] VecArr = new double[2];
    private int dim =2;
    private char world = 'R';

    public vector ( vector vec){
        this.VecArr = new double[vec.getDim()];
        for(int i=0;i<vec.getDim();i++){

            this.VecArr[i]=vec.getVecArr()[i];
        }
        this.world=vec.getWorld();
    }

    public vector (int n){
        this.VecArr = new double[n];
        this.dim =n;
        this.world ='N';
    }

    public vector sum (vector vec){
        if (this.dim != vec.dim) {
            System.out.println("cannot create sum of two vectors from different dimensions  ");
            return null;
        }
        if(this.world!= vec.world){
            System.out.println("cannot sum two vectors from different worlds");
            return null;
        }
        vector res = new vector(this);

        for(int i=0;i<this.dim;i++){
            res.getVecArr()[i]+=vec.getVecArr()[i];
        }
        return res;
    }

    public void multyply(int n){

        if(this.world!='N'){
            System.out.println("ERROR: cannot multiply vector from variable from another world");
            return;
        }
        for(int i=0; i<this.dim;i++){
            this.VecArr[i]*=n;
        }

    }

    public void multyply(double n){

        if(this.world!='R'){
            System.out.println("ERROR: cannot multiply vector from variable from another world");
            return;
        }
        for(int i=0; i<this.dim;i++){
            this.VecArr[i]*=n;
        }

    }


    public char getWorld(){return this.world;}

    public double[] getVecArr() {return VecArr;}

    public void setVecArr(double[] vecArr) {VecArr = vecArr;}

    public int getDim() {return dim;}

    public void setDim(int dim) {this.dim = dim;}



}
