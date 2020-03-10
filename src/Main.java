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
        kMeans.processData();

        System.out.println(kMeans.cluster1.size());
        System.out.println(kMeans.cluster2.size());
        System.out.println(kMeans.cluster3.size());
        System.out.println(kMeans.cluster4.size());
        System.out.println(kMeans.cluster5.size());
        System.out.println(kMeans.cluster6.size());
        System.out.println("=======================");

        System.out.println(kMeans.k1[1]);
        System.out.println(kMeans.k2[0]);

    }


}
