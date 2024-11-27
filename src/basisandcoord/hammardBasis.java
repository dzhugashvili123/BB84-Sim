package basisandcoord;

public class hammardBasis extends basis {
    public hammardBasis() {
        vect1 = new coord((float)(1/Math.sqrt(2)), (float)(1/Math.sqrt(2)));    //|+>
        vect2 = new coord((float)(1/Math.sqrt(2)), (float)(1/Math.sqrt(2)));    //|->
    }
    
    public coord coordtoVector(coord arg) {
        coord ret = new coord(vect1.X*arg.X + vect2.X*arg.X, vect1.Y*arg.Y + vect2.Y*arg.Y);
        return ret;
    }

    public coord vectorToCoord(coord arg) {
        coord ret = new coord(vect1.X*arg.X + vect2.X*arg.X, vect1.Y*arg.Y + vect2.Y*arg.Y);
        return ret;
    }
}
