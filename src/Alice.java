import basisandcoord.*;
import java.util.*;
import newMedium.*;

public class Alice {
    static ArrayList<Integer> x;   //Binary String - anything other than 0 is non-zero
    static ArrayList<Integer> y;

    unitBasis unit = new unitBasis();
    hammardBasis hammard = new hammardBasis();

    public static String convertToBinaryString(ArrayList<Integer> binaryList) {
        StringBuilder sb = new StringBuilder();
        for (Integer bit : binaryList) {
            sb.append(bit);
        }
        return sb.toString();
    }
    public static void main(String args[]){
        x = new ArrayList<Integer>();
        y = new ArrayList<Integer>();
        ArrayList<Integer> y_recv = new ArrayList<Integer>();

        java.util.Random rand = new java.util.Random();

        //Generating y randomly
        for(int i = 0; i < 20; i++){
            int m = rand.nextInt(2);
            int n = rand.nextInt(2);
            int o = rand.nextInt(0, 2);
            x.add(m);   y.add(n);   y_recv.add(o);
        }

        //Encode
        System.out.println("________XXXXX_______"+x);
        System.out.println("________YYYYY_______"+y);
        messageThroughNewMedium msg = new messageThroughNewMedium(x, y);

        //CHECK Y ON RECIEVERS END
        ArrayList<Integer> x_ = msg.checkerAndChanger(y_recv);
        System.out.println(x.size()+" "+y.size()+" "+msg.message.size()+" "+x_.size());

        System.out.println("________Y_Y_Y_Y_____"+y_recv);
        System.out.println("________X_X_X_X_____"+x_);

        //BOB sends the y_ to ALICE, who does the checks it;
        ArrayList<Boolean> check = new ArrayList<Boolean>();
        //Initialise check with true
        for(int i = 0; i < y.size(); i++)
            check.add(Boolean.valueOf(true));
        System.out.println(check.size());

        ArrayList<Integer> key_sender = new ArrayList<Integer>();

        for(int i = 0; i< y.size(); i++)
        {
            if(y.get(i).intValue() ==  y_recv.get(i).intValue())
                key_sender.add(x.get(i));
            else check.set(i, Boolean.valueOf(false));
        }
        System.out.println(check);

        //Check array is passed to the reciever
        //On recievers end
        ArrayList<Integer> key_recv = new ArrayList<Integer>();
        for(int i = 0; i<check.size(); i++)
        {
            if(check.get(i).booleanValue() == true)
                key_recv.add(x_.get(i));
        }

        System.out.println("Senders key : " + convertToBinaryString(key_sender));
        System.out.println("Recievers key : " + convertToBinaryString(key_recv));

    }
}

// public class BB84_sim
// {
//     public static void main(String args[])
//     {

//     }
// }