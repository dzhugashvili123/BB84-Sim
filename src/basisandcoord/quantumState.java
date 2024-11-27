package basisandcoord;

public class quantumState {
    float coorX;
    float coorY;
    quantumState product(quantumState arg){
        //arg are the coordinates of bases according to |1>, |0>, we will return the final vector according to arg
        quantumState ret = new quantumState();
        //Finding vector according to bases
        ret.coorX = this.coorX*arg.coorX;
        ret.coorY = this.coorY*arg.coorY;
        return ret;
    }
}

