package problem;

import individual.Individual;
import loader.TSNode;

import java.util.ArrayList;
import java.util.Collections;


public class TSProblem extends Problem<Integer>{

    private int DIMENSION;
    private String EDGE_WEIGHT_TYPE;
    ArrayList<TSNode> tsNodes;
    private double[][] distanceMatrix;

    public TSProblem(int DIMENSION, String EDGE_WEIGHT_TYPE, ArrayList<TSNode> tsNodes, double[][] distanceMatrix) {
        this.DIMENSION = DIMENSION;
        this.EDGE_WEIGHT_TYPE = EDGE_WEIGHT_TYPE;
        this.tsNodes = tsNodes;
        this.distanceMatrix = distanceMatrix;
    }

    public TSProblem(String PROBLEM_NAME, String PROBLEM_TYPE, String PROBLEM_COMMENT, int DIMENSION, String EDGE_WEIGHT_TYPE, ArrayList<TSNode> tsNodes, double[][] distanceMatrix) {
        super(PROBLEM_NAME, PROBLEM_TYPE, PROBLEM_COMMENT);
        this.DIMENSION = DIMENSION;
        this.EDGE_WEIGHT_TYPE = EDGE_WEIGHT_TYPE;
        this.tsNodes = tsNodes;
        this.distanceMatrix = distanceMatrix;
    }

    public int getDIMENSION() {
        return DIMENSION;
    }

    public void setDIMENSION(int DIMENSION) {
        this.DIMENSION = DIMENSION;
    }

    public String getEDGE_WEIGHT_TYPE() {
        return EDGE_WEIGHT_TYPE;
    }

    public void setEDGE_WEIGHT_TYPE(String EDGE_WEIGHT_TYPE) {
        this.EDGE_WEIGHT_TYPE = EDGE_WEIGHT_TYPE;
    }

    public double[][] getDistanceMatrix() {
        return distanceMatrix;
    }

    public void setDistanceMatrix(double[][] distanceMatrix) {
        this.distanceMatrix = distanceMatrix;
    }

    @Override
    public Individual getIndividual() {
        ArrayList<Integer> genome = new ArrayList<>();
        for(int ii=0; ii< DIMENSION; ii++){
            genome.add(ii);
        }
        Collections.shuffle(genome);
        return new Individual(genome);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("TSProblem{").append('\n');
        res.append(super.toString()).append('\n');
        res.append("DIMENSION= ").append(DIMENSION).append('\n');
        for(int ii=0; ii<DIMENSION; ii++){
            for (int jj = 0; jj < DIMENSION; jj++) {
                res.append(String.format("%4.2f",distanceMatrix[ii][jj])).append('\t');
            }
            res.append('\n');
        }
        res.append('}');
        return res.toString();

    }
}
