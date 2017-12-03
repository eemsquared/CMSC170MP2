import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        XYComponents file = new XYComponents();
        ArrayList<String> arr = file.getList("kmdata1.txt");
        ArrayList<String> X = file.getXComponents();
        ArrayList<String> Y = file.getYComponents();
        //x and y components
        ArrayList<Double> newX = file.getDouble(X);
        ArrayList<Double> newY = file.getDouble(Y);

        //ITER 1
        //values each cluster iter1
        ClusterAssignment cluster_1 = new ClusterAssignment(newX, newY);
        ArrayList<Double> cluster1_1 = cluster_1.getClusterList(3,3);
        ArrayList<Double> cluster2_1 = cluster_1.getClusterList(6, 2);
        ArrayList<Double> cluster3_1 = cluster_1.getClusterList(8, 5);

        //centroid assignments iter1
        ArrayList<Integer> centroidAssignment_1 = cluster_1.getCentroidAssignment(cluster1_1, cluster2_1, cluster3_1);
        cluster_1.writeToFile(centroidAssignment_1, "iter1_ca.txt");

        //get new centroid locations iter1
        NewLocations newLocations_1 = new NewLocations(newX, newY);
        newLocations_1.getNewLocations(centroidAssignment_1);

        double iter1_c1x = newLocations_1.getNewC1x();
        double iter1_c2x = newLocations_1.getNewC2x();
        double iter1_c3x = newLocations_1.getNewC3x();
        double iter1_c1y = newLocations_1.getNewC1y();
        double iter1_c2y = newLocations_1.getNewC2y();
        double iter1_c3y = newLocations_1.getNewC3y();

        //compute for J iter1
        ComputeForJ compJ_1 = new ComputeForJ();
        double J_1 = compJ_1.getJ(cluster1_1, cluster2_1, cluster3_1, centroidAssignment_1);

        newLocations_1.writeToFile(iter1_c1x, iter1_c2x, iter1_c3x, iter1_c1y, iter1_c2y, iter1_c3y, J_1, Math.abs(J_1), "iter1_cm.txt");

        //ITER 2
        //values each cluster iter2
        ClusterAssignment cluster_2 = new ClusterAssignment(newX, newY);
        ArrayList<Double> cluster1_2 = cluster_2.getClusterList(iter1_c1x, iter1_c1y);
        ArrayList<Double> cluster2_2 = cluster_2.getClusterList(iter1_c2x, iter1_c2y);
        ArrayList<Double> cluster3_2 = cluster_2.getClusterList(iter1_c3x, iter1_c3y);

        //centroid assignments iter2
        ArrayList<Integer> centroidAssignment_2 = cluster_2.getCentroidAssignment(cluster1_2, cluster2_2, cluster3_2);
        cluster_2.writeToFile(centroidAssignment_2, "iter2_ca.txt");

        //get new centroid locations iter2
        NewLocations newLocations_2 = new NewLocations(newX, newY);
        newLocations_2.getNewLocations(centroidAssignment_2);

        double iter2_c1x = newLocations_2.getNewC1x();
        double iter2_c2x = newLocations_2.getNewC2x();
        double iter2_c3x = newLocations_2.getNewC3x();
        double iter2_c1y = newLocations_2.getNewC1y();
        double iter2_c2y = newLocations_2.getNewC2y();
        double iter2_c3y = newLocations_2.getNewC3y();

        //compute for J iter2
        ComputeForJ compJ_2 = new ComputeForJ();
        double J_2 = compJ_2.getJ(cluster1_2, cluster2_2, cluster3_2, centroidAssignment_2);

        newLocations_2.writeToFile(iter2_c1x, iter2_c2x, iter2_c3x, iter2_c1y, iter2_c2y, iter2_c3y, J_2, Math.abs(J_2-J_1), "iter2_cm.txt");

        //ITER 3
        //values each cluster iter3
        ClusterAssignment cluster_3 = new ClusterAssignment(newX, newY);
        ArrayList<Double> cluster1_3 = cluster_3.getClusterList(iter2_c1x, iter2_c1y);
        ArrayList<Double> cluster2_3 = cluster_3.getClusterList(iter2_c2x, iter2_c2y);
        ArrayList<Double> cluster3_3 = cluster_3.getClusterList(iter2_c3x, iter2_c3y);

        //centroid assignments iter3
        ArrayList<Integer> centroidAssignment_3 = cluster_3.getCentroidAssignment(cluster1_3, cluster2_3, cluster3_3);
        cluster_2.writeToFile(centroidAssignment_3, "iter3_ca.txt");

        //get new centroid locations iter3
        NewLocations newLocations_3 = new NewLocations(newX, newY);
        newLocations_3.getNewLocations(centroidAssignment_3);

        double iter3_c1x = newLocations_3.getNewC1x();
        double iter3_c2x = newLocations_3.getNewC2x();
        double iter3_c3x = newLocations_3.getNewC3x();
        double iter3_c1y = newLocations_3.getNewC1y();
        double iter3_c2y = newLocations_3.getNewC2y();
        double iter3_c3y = newLocations_3.getNewC3y();

        //compute for J iter3
        ComputeForJ compJ_3 = new ComputeForJ();
        double J_3 = compJ_3.getJ(cluster1_3, cluster2_3, cluster3_3, centroidAssignment_3);

        newLocations_3.writeToFile(iter3_c1x, iter3_c2x, iter3_c3x, iter3_c1y, iter3_c2y, iter3_c3y, J_3, Math.abs(J_3 - J_2), "iter3_cm.txt");

        //ITER 4
        //values each cluster iter4
        ClusterAssignment cluster_4 = new ClusterAssignment(newX, newY);
        ArrayList<Double> cluster1_4 = cluster_4.getClusterList(iter3_c1x, iter3_c1y);
        ArrayList<Double> cluster2_4 = cluster_4.getClusterList(iter3_c2x, iter3_c2y);
        ArrayList<Double> cluster3_4 = cluster_4.getClusterList(iter3_c3x, iter3_c3y);

        //centroid assignments iter3
        ArrayList<Integer> centroidAssignment_4 = cluster_4.getCentroidAssignment(cluster1_4, cluster2_4, cluster3_4);
        cluster_2.writeToFile(centroidAssignment_4, "iter4_ca.txt");

        //get new centroid locations iter4
        NewLocations newLocations_4 = new NewLocations(newX, newY);
        newLocations_4.getNewLocations(centroidAssignment_4);

        double iter4_c1x = newLocations_4.getNewC1x();
        double iter4_c2x = newLocations_4.getNewC2x();
        double iter4_c3x = newLocations_4.getNewC3x();
        double iter4_c1y = newLocations_4.getNewC1y();
        double iter4_c2y = newLocations_4.getNewC2y();
        double iter4_c3y = newLocations_4.getNewC3y();

        //compute for J iter4
        ComputeForJ compJ_4 = new ComputeForJ();
        double J_4 = compJ_4.getJ(cluster1_4, cluster2_4, cluster3_4, centroidAssignment_4);

        newLocations_4.writeToFile(iter4_c1x, iter4_c2x, iter4_c3x, iter4_c1y, iter4_c2y, iter4_c3y, J_4, Math.abs(J_4 - J_3), "iter4_cm.txt");


        //ITER 5
        //values each cluster iter5
        ClusterAssignment cluster_5 = new ClusterAssignment(newX, newY);
        ArrayList<Double> cluster1_5 = cluster_5.getClusterList(iter4_c1x, iter4_c1y);
        ArrayList<Double> cluster2_5 = cluster_5.getClusterList(iter4_c2x, iter4_c2y);
        ArrayList<Double> cluster3_5 = cluster_5.getClusterList(iter4_c3x, iter4_c3y);

        //centroid assignments iter5
        ArrayList<Integer> centroidAssignment_5 = cluster_5.getCentroidAssignment(cluster1_5, cluster2_5, cluster3_5);
        cluster_5.writeToFile(centroidAssignment_5, "iter5_ca.txt");

        //get new centroid locations iter5
        NewLocations newLocations_5 = new NewLocations(newX, newY);
        newLocations_5.getNewLocations(centroidAssignment_5);

        double iter5_c1x = newLocations_5.getNewC1x();
        double iter5_c2x = newLocations_5.getNewC2x();
        double iter5_c3x = newLocations_5.getNewC3x();
        double iter5_c1y = newLocations_5.getNewC1y();
        double iter5_c2y = newLocations_5.getNewC2y();
        double iter5_c3y = newLocations_5.getNewC3y();

        //compute for J iter5
        ComputeForJ compJ_5 = new ComputeForJ();
        double J_5 = compJ_5.getJ(cluster1_5, cluster2_5, cluster3_5, centroidAssignment_5);

        newLocations_5.writeToFile(iter5_c1x, iter5_c2x, iter5_c3x, iter5_c1y, iter5_c2y, iter5_c3y, J_5, Math.abs(J_5 - J_4), "iter5_cm.txt");

        //ITER 6
        //values each cluster iter6
        ClusterAssignment cluster_6 = new ClusterAssignment(newX, newY);
        ArrayList<Double> cluster1_6 = cluster_6.getClusterList(iter5_c1x, iter5_c1y);
        ArrayList<Double> cluster2_6 = cluster_6.getClusterList(iter5_c2x, iter5_c2y);
        ArrayList<Double> cluster3_6 = cluster_6.getClusterList(iter5_c3x, iter5_c3y);

        //centroid assignments iter6
        ArrayList<Integer> centroidAssignment_6 = cluster_6.getCentroidAssignment(cluster1_6, cluster2_6, cluster3_6);
        cluster_6.writeToFile(centroidAssignment_6, "iter6_ca.txt");

        //get new centroid locations iter6
        NewLocations newLocations_6 = new NewLocations(newX, newY);
        newLocations_6.getNewLocations(centroidAssignment_6);

        double iter6_c1x = newLocations_6.getNewC1x();
        double iter6_c2x = newLocations_6.getNewC2x();
        double iter6_c3x = newLocations_6.getNewC3x();
        double iter6_c1y = newLocations_6.getNewC1y();
        double iter6_c2y = newLocations_6.getNewC2y();
        double iter6_c3y = newLocations_6.getNewC3y();

        //compute for J iter6
        ComputeForJ compJ_6 = new ComputeForJ();
        double J_6 = compJ_6.getJ(cluster1_6, cluster2_6, cluster3_6, centroidAssignment_6);

        newLocations_6.writeToFile(iter6_c1x, iter6_c2x, iter6_c3x, iter6_c1y, iter6_c2y, iter6_c3y, J_6, Math.abs(J_6 - J_5), "iter6_cm.txt");

        //ITER 7
        //values each cluster iter7
        ClusterAssignment cluster_7 = new ClusterAssignment(newX, newY);
        ArrayList<Double> cluster1_7 = cluster_7.getClusterList(iter6_c1x, iter6_c1y);
        ArrayList<Double> cluster2_7 = cluster_7.getClusterList(iter6_c2x, iter6_c2y);
        ArrayList<Double> cluster3_7 = cluster_7.getClusterList(iter6_c3x, iter6_c3y);

        //centroid assignments iter7
        ArrayList<Integer> centroidAssignment_7 = cluster_7.getCentroidAssignment(cluster1_7, cluster2_7, cluster3_7);
        cluster_7.writeToFile(centroidAssignment_7, "iter7_ca.txt");

        //get new centroid locations iter7
        NewLocations newLocations_7 = new NewLocations(newX, newY);
        newLocations_7.getNewLocations(centroidAssignment_7);

        double iter7_c1x = newLocations_7.getNewC1x();
        double iter7_c2x = newLocations_7.getNewC2x();
        double iter7_c3x = newLocations_7.getNewC3x();
        double iter7_c1y = newLocations_7.getNewC1y();
        double iter7_c2y = newLocations_7.getNewC2y();
        double iter7_c3y = newLocations_7.getNewC3y();

        //compute for J iter7
        ComputeForJ compJ_7 = new ComputeForJ();
        double J_7 = compJ_7.getJ(cluster1_7, cluster2_7, cluster3_7, centroidAssignment_7);

        newLocations_7.writeToFile(iter7_c1x, iter7_c2x, iter7_c3x, iter7_c1y, iter7_c2y, iter7_c3y, J_7, Math.abs(J_7 - J_6), "iter7_cm.txt");

        //ITER 8
        //values each cluster iter8
        ClusterAssignment cluster_8 = new ClusterAssignment(newX, newY);
        ArrayList<Double> cluster1_8 = cluster_8.getClusterList(iter7_c1x, iter7_c1y);
        ArrayList<Double> cluster2_8 = cluster_8.getClusterList(iter7_c2x, iter7_c2y);
        ArrayList<Double> cluster3_8 = cluster_8.getClusterList(iter7_c3x, iter7_c3y);

        //centroid assignments iter8
        ArrayList<Integer> centroidAssignment_8 = cluster_8.getCentroidAssignment(cluster1_8, cluster2_8, cluster3_8);
        cluster_8.writeToFile(centroidAssignment_8, "iter8_ca.txt");

        //get new centroid locations iter8
        NewLocations newLocations_8 = new NewLocations(newX, newY);
        newLocations_8.getNewLocations(centroidAssignment_8);

        double iter8_c1x = newLocations_8.getNewC1x();
        double iter8_c2x = newLocations_8.getNewC2x();
        double iter8_c3x = newLocations_8.getNewC3x();
        double iter8_c1y = newLocations_8.getNewC1y();
        double iter8_c2y = newLocations_8.getNewC2y();
        double iter8_c3y = newLocations_8.getNewC3y();

        //compute for J iter8
        ComputeForJ compJ_8 = new ComputeForJ();
        double J_8 = compJ_8.getJ(cluster1_8, cluster2_8, cluster3_8, centroidAssignment_8);

        newLocations_8.writeToFile(iter8_c1x, iter8_c2x, iter8_c3x, iter8_c1y, iter8_c2y, iter8_c3y, J_8, Math.abs(J_8 - J_7), "iter8_cm.txt");

        //ITER 9
        //values each cluster iter9
        ClusterAssignment cluster_9 = new ClusterAssignment(newX, newY);
        ArrayList<Double> cluster1_9 = cluster_9.getClusterList(iter8_c1x, iter8_c1y);
        ArrayList<Double> cluster2_9 = cluster_9.getClusterList(iter8_c2x, iter8_c2y);
        ArrayList<Double> cluster3_9 = cluster_9.getClusterList(iter8_c3x, iter8_c3y);

        //centroid assignments iter9
        ArrayList<Integer> centroidAssignment_9 = cluster_9.getCentroidAssignment(cluster1_9, cluster2_9, cluster3_9);
        cluster_9.writeToFile(centroidAssignment_9, "iter9_ca.txt");

        //get new centroid locations iter9
        NewLocations newLocations_9 = new NewLocations(newX, newY);
        newLocations_9.getNewLocations(centroidAssignment_9);

        double iter9_c1x = newLocations_9.getNewC1x();
        double iter9_c2x = newLocations_9.getNewC2x();
        double iter9_c3x = newLocations_9.getNewC3x();
        double iter9_c1y = newLocations_9.getNewC1y();
        double iter9_c2y = newLocations_9.getNewC2y();
        double iter9_c3y = newLocations_9.getNewC3y();

        //compute for J iter9
        ComputeForJ compJ_9 = new ComputeForJ();
        double J_9 = compJ_9.getJ(cluster1_9, cluster2_9, cluster3_9, centroidAssignment_9);

        newLocations_9.writeToFile(iter9_c1x, iter9_c2x, iter9_c3x, iter9_c1y, iter9_c2y, iter9_c3y, J_9, Math.abs(J_9 - J_8), "iter9_cm.txt");

        //ITER 10
        //values each cluster iter10
        ClusterAssignment cluster_10 = new ClusterAssignment(newX, newY);
        ArrayList<Double> cluster1_10 = cluster_10.getClusterList(iter9_c1x, iter9_c1y);
        ArrayList<Double> cluster2_10 = cluster_10.getClusterList(iter9_c2x, iter9_c2y);
        ArrayList<Double> cluster3_10 = cluster_10.getClusterList(iter9_c3x, iter9_c3y);

        //centroid assignments iter10
        ArrayList<Integer> centroidAssignment_10 = cluster_10.getCentroidAssignment(cluster1_10, cluster2_10, cluster3_10);
        cluster_10.writeToFile(centroidAssignment_10, "iter10_ca.txt");

        //get new centroid locations iter10
        NewLocations newLocations_10 = new NewLocations(newX, newY);
        newLocations_10.getNewLocations(centroidAssignment_10);

        double iter10_c1x = newLocations_10.getNewC1x();
        double iter10_c2x = newLocations_10.getNewC2x();
        double iter10_c3x = newLocations_10.getNewC3x();
        double iter10_c1y = newLocations_10.getNewC1y();
        double iter10_c2y = newLocations_10.getNewC2y();
        double iter10_c3y = newLocations_10.getNewC3y();

        //compute for J iter10
        ComputeForJ compJ_10 = new ComputeForJ();
        double J_10 = compJ_10.getJ(cluster1_10, cluster2_10, cluster3_10, centroidAssignment_10);

        newLocations_10.writeToFile(iter10_c1x, iter10_c2x, iter10_c3x, iter10_c1y, iter10_c2y, iter10_c3y, J_10, Math.abs(J_10 - J_9), "iter10_cm.txt");

    }
}

