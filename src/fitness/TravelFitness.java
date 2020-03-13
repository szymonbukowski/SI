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
    public double countFitness(Individual<Integer> individual) {
        ArrayList<Integer> genes = individual.getGenome().getGenes();
        double res = 0.0;

        for(int ii=0; ii<genes.size(); ii++){
            res+= distanceMatrix[ii][ii+1];
        }
        res += distanceMatrix[genes.size()-1][0];
        individual.setFitness(res);
        return res;
    }
}
