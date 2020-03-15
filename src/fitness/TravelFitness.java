package fitness;

import individual.Individual;

import java.util.ArrayList;

public class TravelFitness implements IFitness<Integer>{

    private double[][] distanceMatrix;

    public TravelFitness(double[][] distanceMatrix) {
        this.distanceMatrix = distanceMatrix;
    }

    public double[][] getDistanceMatrix() {
        return distanceMatrix;
    }

    public void setDistanceMatrix(double[][] distanceMatrix) {
        this.distanceMatrix = distanceMatrix;
    }

    @Override
    public double evaluate(Individual<Integer> individual) {
        ArrayList<Integer> genes = individual.getGenome();
        double res = 0.0;

        for(int ii=1; ii<genes.size(); ii++){
            int from = genes.get(ii-1);
            int to = genes.get(ii);
            res += distanceMatrix[from][to];
        }

        res += distanceMatrix[genes.get(genes.size()-1)][genes.get(0)];
        individual.setFitness(res);
        return res;
    }
}
