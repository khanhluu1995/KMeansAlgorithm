import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class KMeans {
     ArrayList<double[]> cluster1;
     ArrayList<double[]> cluster2;
     ArrayList<double[]> cluster3;
     ArrayList<double[]> cluster4;
     ArrayList<double[]> cluster5;
     ArrayList<double[]> cluster6;
    double[] k1,k2,k3,k4,k5,k6;
    double[][] inputData;
    int algorithmNumOfLoops = 100;
    FileWriter fileWriter;

    public KMeans(double[][] inputData){
        this.inputData = inputData;
        //RANDOMLY pick k means
        k1 = inputData[0];
        k2 = inputData[99];
        k3 = inputData[199];
        k4 = inputData[299];
        k5 = inputData[399];
        k6 = inputData[499];
    }

    private  void clusterIdentifier(int chosen, double[] addThis){

        switch (chosen){
            case 1:
                cluster1.add(addThis);
                break;

            case 2:
                cluster2.add(addThis);
                break;
            case 3:
                cluster3.add(addThis);
                break;
            case 4:
                cluster4.add(addThis);
                break;
            case 5:
                cluster5.add(addThis);
                break;
            case 6:
                cluster6.add(addThis);
                break;

            default:
                System.out.println("something wrong");
                break;

        }

    }

    private void findTheClosestDistance(double[] candidate){

        double closest = 100000;
        int chosen = 0;
        double[] distance = new double[6];
        //chose 6 because we have 6 k means to compare with

        for(int i =0; i < candidate.length;i++){
            distance[0] += Math.pow(k1[i]-candidate[i],2);
            if(i == 59){
                distance[0] = Math.sqrt(distance[0]);
            }
        }

        for(int i =0; i < candidate.length;i++){
            distance[1] += Math.pow(k2[i]-candidate[i],2);
            if(i == 59){
                distance[1] = Math.sqrt(distance[1]);
            }
        }

        for(int i =0; i < candidate.length;i++){
            distance[2] += Math.pow(k3[i]-candidate[i],2);
            if(i == 59){
                distance[2] = Math.sqrt(distance[2]);
            }
        }

        for(int i =0; i < candidate.length;i++){
            distance[3] += Math.pow(k4[i]-candidate[i],2);
            if(i == 59){
                distance[3] = Math.sqrt(distance[3]);
            }
        }

        for(int i =0; i < candidate.length;i++){
            distance[4] += Math.pow(k5[i]-candidate[i],2);
            if(i == 59){
                distance[4] = Math.sqrt(distance[4]);
            }
        }


        for(int i =0; i < candidate.length;i++){
            distance[5] += Math.pow(k6[i]-candidate[i],2);
            if(i == 59){
                distance[5] = Math.sqrt(distance[5]);
            }
        }

        for (int i = 0; i < distance.length; i++){
//            System.out.println(distance[i]);
            if(closest > distance[i]){
                closest = distance[i];
                chosen = i+1;
            }



        }

//        System.out.println("====================================");
        clusterIdentifier(chosen,candidate);
    }

    //start to process data by calculating distances between the candidate to the 6 k means
    public void processData(){
        cluster1= new ArrayList<>();
        cluster2= new ArrayList<>();
        cluster3= new ArrayList<>();
        cluster4= new ArrayList<>();
        cluster5= new ArrayList<>();
        cluster6= new ArrayList<>();
        for(int i = 0; i < inputData.length; i++){
            findTheClosestDistance(inputData[i]);
        }

        k1 = findNewMean(cluster1);
        k2 = findNewMean(cluster2);
        k3 = findNewMean(cluster3);
        k4 = findNewMean(cluster4);
        k5 = findNewMean(cluster5);
        k6 = findNewMean(cluster6);
        algorithmNumOfLoops--;
//        printClusterSize();
//        System.out.println("=====END OF ITERATION=====");
        if(algorithmNumOfLoops > 0){
            processData();
        }
        else {
            writeToCSV();
        }
    }


    private double[] findNewMean(ArrayList<double[]> myCluster){
        double[] res = new double[60];

        for(int i = 0; i < res.length; i++){
            for(int j = 0; j < myCluster.size();j++){
                res [i] += myCluster.get(j)[i];
            }
            res[i] /= myCluster.size();
        }
        return res;
    }
    
    public void printClusterSize(){
        System.out.println("The 6 cluster sizes are: ");
        System.out.println(cluster1.size());
        System.out.println(cluster2.size());
        System.out.println(cluster3.size());
        System.out.println(cluster4.size());
        System.out.println(cluster5.size());
        System.out.println(cluster6.size());
    }
    
    private void writeToCSV() {
        try {
            chooseCluster("cluster1.txt", cluster1);
            chooseCluster("cluster2.txt", cluster2);
            chooseCluster("cluster3.txt", cluster3);
            chooseCluster("cluster4.txt", cluster4);
            chooseCluster("cluster5.txt", cluster5);
            chooseCluster("cluster6.txt", cluster6);

        }catch (IOException ex){
            System.out.println("Failed to write to csv");
            ex.printStackTrace();
        }

    }

    private void chooseCluster(String filename, ArrayList<double[]> myCluster) throws IOException{
        fileWriter = new FileWriter(filename);
        for(int i = 0; i < myCluster.size(); i++){
            //60 columns
            for(int j = 0; j < 60; j++){
                fileWriter.write(Double.toString(myCluster.get(i)[j]) + " ");
            }
            fileWriter.write("\n");
        }
        fileWriter.close();
    }
}
