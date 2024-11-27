package basisandcoord;

public class unitBasis extends basis {
    public unitBasis(){
        vect1 = new coord(1, 0);    //|1>
        vect2 = new coord(0,1);     //|0>
    }

    public coord coordtoVector(coord arg) {
        coord ret = new coord(vect1.X*arg.X + vect2.X*arg.X, vect1.Y*arg.Y + vect2.Y*arg.Y);
        ret.X = vect1.X*arg.X + vect2.X*arg.X;
        ret.Y = vect1.Y*arg.Y + vect2.Y*arg.Y;
        return ret;
    }

    public coord vectorToCoord(coord arg) {
        coord ret = new coord(vect1.X*arg.X + vect2.X*arg.X, vect1.Y*arg.Y + vect2.Y*arg.Y);
        return ret;
    }
}
