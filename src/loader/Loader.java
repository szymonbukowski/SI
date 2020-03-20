package loader;

import fitness.IFitness;
import fitness.TravelFitness;
import problem.TSProblem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Loader {

    String PROBLEM_NAME;
    String PROBLEM_TYPE;
    String PROBLEM_COMMENT;
    int DIMENSION;
    String EDGE_WEIGHT_TYPE;
    ArrayList<TSNode> TSNodes;

    private BufferedReader br;

    public Loader(){
        TSNodes = new ArrayList<>();
    }


    public boolean loadByFileName(String filename){
        File f = new File("./data/" + filename);
        loadByFile(f);
        return true;
    }

    public boolean loadByFile(File problemFile){
        try{
            br = new BufferedReader(new FileReader(problemFile));
        }catch (IOException e){
            e.printStackTrace();
        }
        try{

            PROBLEM_NAME = splitReadLine();
            PROBLEM_TYPE = splitReadLine();
            PROBLEM_COMMENT = splitReadLine();
            DIMENSION = Integer.parseInt(splitReadLine());
            EDGE_WEIGHT_TYPE = splitReadLine();

            br.readLine();
            for(int i = 0; i < DIMENSION; i++) {
                TSNodes.add(readNode());
            }

        }catch (IOException e){
            e.printStackTrace();
        }




        return true;
    }

    private String splitReadLine() throws IOException {
        return br.readLine().split(":")[1].replace(" ", "");
    }

    private TSNode readNode() throws IOException {
        String[] nodeInfo = br.readLine().split(" ");

        return new TSNode(Integer.parseInt(nodeInfo[0]),
                        Double.parseDouble(nodeInfo[1]),
                        Double.parseDouble(nodeInfo[2]));
    }

    private double[][] createDistanceMatrix(IDistanceMeter distanceMeter) {
        double[][] matrix = new double[DIMENSION][DIMENSION];
        for (int i = 0; i < DIMENSION; i++){
            for (int j = 0; j < DIMENSION; j++) {
                if (i == j)
                    matrix[i][j] = 0.0;
                else
                    matrix[i][j] = distanceMeter.getDistance(TSNodes.get(i), TSNodes.get(j));
            }
        }

        return matrix;
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        result.append("PROBLEM_NAME: ").append(PROBLEM_NAME).append('\n');
        result.append("PROBLEM_TYPE: ").append(PROBLEM_TYPE).append('\n');
        result.append("PROBLEM_COMMENT: ").append(PROBLEM_COMMENT).append('\n');
        result.append("DIMENSION: ").append(DIMENSION).append('\n');
        result.append("EDGE_WEIGHT_TYPE: ").append(EDGE_WEIGHT_TYPE).append('\n');
        result.append("nodes:").append('\n');
        for(TSNode n: TSNodes){
            result.append(n.toString());
            result.append('\n');
        }
        return result.toString();
    }
    public void print(){
        System.out.println( this.toString() );
    }

    public TSProblem getProblem() {
        switch (PROBLEM_TYPE){
            case "TSP":{
                IDistanceMeter distanceMeter;
                switch (EDGE_WEIGHT_TYPE){
                    case "GEO":
                        distanceMeter = new RadialDistanceMeter(6378);
                        break;
                    default:
                        distanceMeter = new Euclides2dDistanceMeter();
                }
                double[][] distanceMatrix = createDistanceMatrix(distanceMeter);
                IFitness fitnesCounter = new TravelFitness(distanceMatrix);
                TSProblem res = new TSProblem(PROBLEM_NAME, PROBLEM_TYPE, PROBLEM_COMMENT, DIMENSION, EDGE_WEIGHT_TYPE, distanceMatrix);
                res.setFitnessCounter(fitnesCounter);
                return res;
            }
            default:
            return null;
        }
    }


}
