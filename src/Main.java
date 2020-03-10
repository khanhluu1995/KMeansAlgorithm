import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) throws IOException {
        File file = new File("synthetic_control_data.txt");
        Scanner scanner = new Scanner(file);
        final int row = 600;
        final int column = 60;
        double[][] inputData = new double[row][column];
        int i = 0;
        while(scanner.hasNext()){
            int j = 0;
            while(j<column){
                inputData[i][j] = Double.parseDouble(scanner.next());
                j++;
            }
            i++;
        }

        KMeans kMeans = new KMeans(inputData);
//        System.out.println(kMeans.k1[0]);
//        System.out.println(kMeans.k2[0]);
//        System.out.println(kMeans.k3[0]);
//        System.out.println(kMeans.k4[0]);
//        System.out.println(kMeans.k5[0]);
//        System.out.println(kMeans.k6[0]);
//
//        System.out.println("=======================");
//        System.out.println("After processing data: ");
        kMeans.processData();
//
//        System.out.println("kmeans: ");
//        System.out.println(kMeans.k1[0]);
//        System.out.println(kMeans.k2[0]);
//        System.out.println(kMeans.k3[0]);
//        System.out.println(kMeans.k4[0]);
//        System.out.println(kMeans.k5[0]);
//        System.out.println(kMeans.k6[0]);

//        System.out.println(kMeans.cluster2.size());
//        System.out.println(kMeans.cluster2.get(17)[17]);


    }


}
