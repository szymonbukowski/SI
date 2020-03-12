package loader;

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
    ArrayList<Node> nodes;

    private BufferedReader br;

    public Loader(){
        nodes = new ArrayList<>();
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
                nodes.add(readNode());
            }

        }catch (IOException e){
            e.printStackTrace();
        }




        return true;
    }

    private String splitReadLine() throws IOException {
        return br.readLine().split(":")[1].replace(" ", "");
    }

    private Node readNode() throws IOException {
        String[] nodeInfo = br.readLine().split(" ");

        return new Node(Integer.parseInt(nodeInfo[0]),
                        Double.parseDouble(nodeInfo[1]),
                        Double.parseDouble(nodeInfo[2]));
    }

    public double[][] createDistanceMatrix() {
        double[][] matrix = new double[DIMENSION][DIMENSION];
        for (int i = 0; i < DIMENSION; i++){
            for (int j = 0; j < DIMENSION; j++) {
                if (i == j)
                    matrix[i][j] = 0.0;
                else
                    matrix[i][j] = getDistance(nodes.get(i), nodes.get(j));
            }
        }

        return matrix;
    }

    private double getDistance(Node node1, Node node2) {
        return   Math.sqrt( Math.pow(node2.getPosX()-node1.getPosX(), 2) + Math.pow(node2.getPosY()-node1.getPosY(), 2) );
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
        for(Node n: nodes){
            result.append(n.toString());
            result.append('\n');
        }
        return result.toString();
    }
    public void print(){
        System.out.println( this.toString() );
    }
}
