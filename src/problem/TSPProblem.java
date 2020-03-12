package problem;

import individual.Genome;
import individual.Individual;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class TSPProblem extends Problem{

    private int DIMENSION;
    private String EDGE_WEIGHT_TYPE;
    private double[][] distanceMatrix;

    public TSPProblem(int DIMENSION, String EDGE_WEIGHT_TYPE, double[][] distanceMatrix) {
        this.DIMENSION = DIMENSION;
        this.EDGE_WEIGHT_TYPE = EDGE_WEIGHT_TYPE;
        this.distanceMatrix = distanceMatrix;
    }

    public TSPProblem(String PROBLEM_NAME, String PROBLEM_TYPE, String PROBLEM_COMMENT, int DIMENSION, String EDGE_WEIGHT_TYPE, double[][] distanceMatrix) {
        super(PROBLEM_NAME, PROBLEM_TYPE, PROBLEM_COMMENT);
        this.DIMENSION = DIMENSION;
        this.EDGE_WEIGHT_TYPE = EDGE_WEIGHT_TYPE;
        this.distanceMatrix = distanceMatrix;
    }

    @Override
    public Individual getIndividual() {
        ArrayList<Integer> genom = new ArrayList<>();
        for(int ii=0; ii< DIMENSION; ii++){
            genom.add(ii);
        }
        Collections.shuffle(genom);
        return new Individual<>(new Genome<>(genom));
    }
}
