import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class XYComponents {

    private String filename;
    private ArrayList<String> list = new ArrayList<>();
    private ArrayList<String> X = new ArrayList<>();
    private ArrayList<String> Y = new ArrayList<>();
    String holder;
    String getComp;
    String x;
    String y;
    double sampDoub;

    public ArrayList<String> getList(String filename){
        this.filename = filename;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                list.add(sCurrentLine);
            }
            parseComponents(list);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void parseComponents(ArrayList<String> list){
        this.list = list;

        for(int i = 0; i < list.size(); i++){
            holder = list.get(i);
            x = holder.substring(1, 16);
            y = holder.substring(17, 32);
            X.add(x);
            Y.add(y);
        }
    }

    public ArrayList<String> getXComponents(){
        return X;
    }

    public ArrayList<String> getYComponents(){
        return Y;
    }

    public ArrayList<Double> getDouble(ArrayList<String> compList){
        ArrayList<Double> newList = new ArrayList<>();
        for (int i = 0; i < compList.size(); i++){
            getComp = compList.get(i);
            sampDoub = Double.parseDouble(getComp);
            newList.add(sampDoub);
        }
        return newList;
    }




}
