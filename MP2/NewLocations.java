import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class NewLocations {
    ArrayList<Double> X = new ArrayList<>();
    ArrayList<Double> Y = new ArrayList<>();

    double newC1x = 0;
    double newC2x = 0;
    double newC3x = 0;

    double newC1y = 0;
    double newC2y = 0;
    double newC3y = 0;

    int size1 = 0;
    int size2 = 0;
    int size3 = 0;

    NewLocations(ArrayList<Double> X,ArrayList<Double> Y){
        this.X = X;
        this.Y = Y;
    }

    public void getNewLocations(ArrayList<Integer> clusters) {

        int cluster;
        for(int i = 0; i < 300; i++){
            cluster = clusters.get(i);
            if(cluster == 1){
                size1++;
                newC1x = newC1x + X.get(i);
                newC1y = newC1y + Y.get(i);
            }
            else if(cluster == 2){
                size2++;
                newC2x = newC2x + X.get(i);
                newC2y = newC2y + Y.get(i);
            }
            else if(cluster == 3){
                size3++;
                newC3x = newC3x + X.get(i);
                newC3y = newC3y + Y.get(i);
            }
        }

    }

    public double getNewC1x(){
        return newC1x/size1;
    }

    public double getNewC1y() {
        return newC1y/size1;
    }

    public double getNewC2x() {
        return newC2x/size2;
    }

    public double getNewC2y() {
        return newC2y/size2;
    }

    public double getNewC3x() {
        return newC3x/size3;
    }

    public double getNewC3y() {
        return newC3y/size3;
    }

    public void writeToFile(double cx1, double cx2, double cx3, double cy1, double cy2, double cy3, double j, double diff,  String filename){
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

            bw.write(Double.toString(cx1));
            bw.write(" , ");
            bw.write(Double.toString(cy1));
            bw.newLine();

            bw.write(Double.toString(cx2));
            bw.write(" , ");
            bw.write(Double.toString(cy2));
            bw.newLine();

            bw.write(Double.toString(cx3));
            bw.write(" , ");
            bw.write(Double.toString(cy3));
            bw.newLine();
            bw.newLine();
            bw.write("J = ");
            bw.write(Double.toString(j));

            bw.newLine();
            bw.write("dJ = ");
            bw.write(Double.toString(diff));

            System.out.println("Written successfully to iter_cm\n");

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
