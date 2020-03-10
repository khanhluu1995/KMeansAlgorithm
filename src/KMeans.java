import java.util.ArrayList;

public class KMeans {
    public ArrayList<double[]> cluster1 = new ArrayList<>();
    public ArrayList<double[]> cluster2 = new ArrayList<>();
    public ArrayList<double[]> cluster3 = new ArrayList<>();
    public ArrayList<double[]> cluster4 = new ArrayList<>();
    public ArrayList<double[]> cluster5 = new ArrayList<>();
    public ArrayList<double[]> cluster6 = new ArrayList<>();
    //RANDOMLY pick k means
    double[] k1,k2,k3,k4,k5,k6;
    double[][] inputData;

    public KMeans(double[][] inputData){
        this.inputData = inputData;
        k1 = inputData[0];
        k2 = inputData[0];
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

    public void processData(){
        for(int i = 0; i < 2; i++){
            findTheClosestDistance(inputData[i]);
        }

        k1 = findNewMean(cluster1);
        k2 = findNewMean(cluster2);

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
}
