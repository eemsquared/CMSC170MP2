import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ClusterAssignment {
    ArrayList<Double> X = new ArrayList<>();
    ArrayList<Double> Y = new ArrayList<>();
    double x;
    double y;
    double clusterValue;
    int m = 300;

    ClusterAssignment(ArrayList<Double> X, ArrayList<Double> Y){
        this.X = X;
        this.Y = Y;
    }

    public ArrayList<Double> getClusterList(double muX, double muY){
        ArrayList<Double> clusterList = new ArrayList<>();
        for(int i = 0; i < m; i++){
            x = X.get(i);
            y = Y.get(i);
            clusterValue = Math.sqrt((Math.pow((x-muX), 2)) + (Math.pow((y-muY), 2)));
            clusterList.add(clusterValue);
        }
        return clusterList;
    }

    public ArrayList<Integer> getCentroidAssignment(ArrayList<Double> c1,ArrayList<Double> c2, ArrayList<Double> c3) {
        ArrayList<Integer> centroidAssigned = new ArrayList<>();
        double mu1;
        double mu2;
        double mu3;
        double preJ = 0;

        for (int i = 0; i < 300; i++){
            mu1 = c1.get(i);
            mu2 = c2.get(i);
            mu3 = c3.get(i);

            if(mu2 > mu1 && mu3 > mu1){
                centroidAssigned.add(1);
            }
            else if(mu3 > mu2 && mu1 > mu2){
                centroidAssigned.add(2);
            }
            else if(mu1 > mu3 && mu2 > mu3){
                centroidAssigned.add(3);
            }
        }
        return centroidAssigned;
    }

    public ArrayList<Double> getNewLocation(ArrayList<Integer> clusters) {
        return X;
    }


    public void writeToFile(ArrayList<Integer> clusters, String filename){
        BufferedWriter bw = null;
        try{
            String str;
            int val;
            File file = new File(filename);

            if(file.exists()){
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            for(int i = 0; i < 300; i++){
                val = clusters.get(i);
                str = Integer.toString(val);
                bw.write(str);
                bw.newLine();
            }
            System.out.println("Written successfully to iter_ca");

        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
        finally {
            try{
                if(bw!= null)
                    bw.close();
            }catch(Exception ex){
                System.out.println("Error closing the BufferedWriter" + ex);
            }
        }

    }

}
