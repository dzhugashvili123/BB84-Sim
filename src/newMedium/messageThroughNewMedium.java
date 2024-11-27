package newMedium;
import basisandcoord.*;
import java.util.*;

public class messageThroughNewMedium {
    public ArrayList<coord> message;
    static boolean eavesdropCheck = false;

    int revMap(coord arg, int y_)
    {
        java.util.Random rand = new java.util.Random();
        if(arg.X == 1 && arg.Y == 0)
        {
            if(y_ == 0) return 0;
            else return rand.nextInt(0,2);
        }
        else if(arg.X == 0 & arg.Y == 1)
        {
            if(y_ == 0) return 1;
            else return rand.nextInt(0,2);
        }
        else if(arg.X == (float)(1/Math.sqrt(2)) && arg.Y == (float)(1/Math.sqrt(2)))
        {
            if( y_ == 1)    return 0;
            else return rand.nextInt(0,2);
        }
        else
        {
            if(y_ == 1) return 1;
            else return rand.nextInt(0,2);
        }
    }

    public messageThroughNewMedium(ArrayList<Integer> x, ArrayList<Integer> y) {
        message = new ArrayList<coord>();
        // Iterator<Integer> xIterator = x.iterator();
        // Iterator<Integer> yIterator = y.iterator();
        for(int yVar = 0; yVar < y.size(); yVar++)
        {
            if(y.get(yVar) == 0)   //Unit Basis
            {
                if(x.get(yVar) == 0)
                    message.add(new coord(1, 0));
                else    message.add(new coord(0, 1));
            }
            else
            {
                if(x.get(yVar) == 0)
                    message.add(new coord((float)(1/Math.sqrt(2)), (float)(1/Math.sqrt(2))));
                else    message.add(new coord((float)(1/Math.sqrt(2)), -(float)(1/Math.sqrt(2))));
            }
        }
    }
    public ArrayList<Integer> checkerAndChanger(ArrayList<Integer> y_) {
        unitBasis unit = new unitBasis();
        hammardBasis hammard = new hammardBasis();

        java.util.Random rand = new java.util.Random();
        ArrayList<coord> set = new ArrayList<coord>();
        set.add(unit.vect1);
        set.add(unit.vect2);
        set.add(hammard.vect1);
        set.add(hammard.vect2);

        ArrayList<Integer> x_ = new ArrayList<>();

        for (int i = 0; i < message.size() ; i++) {
            int r = rand.nextInt(0, 4);
            if (y_.get(i) == 0) {  // Unit Basis
                x_.add(revMap(message.get(i), y_.get(i)));
                message.set(i, set.get(r));
            } else {  // Hammard Basis
                x_.add(revMap(message.get(i), y_.get(i)));
                message.set(i, set.get(r));
            }
        }
        return x_;
    }
    
}
