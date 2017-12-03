import java.util.ArrayList;

public class ComputeForJ {

    double J = 0;

    public double getJ(ArrayList<Double> c1, ArrayList<Double> c2, ArrayList<Double> c3, ArrayList<Integer> cent){
        int loc;

        for(int i = 0; i < cent.size(); i++){
            loc = cent.get(i);
            if(loc == 1){
                J = J + c1.get(i);
            }
            else if(loc == 2){
                J = J + c2.get(i);
            }
            else if(loc == 3){
                J = J + c3.get(i);
            }
        }
    return J/300;
    }
}
