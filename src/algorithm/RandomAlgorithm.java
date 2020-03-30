package algorithm;

import fitness.IFitness;
import individual.Individual;
import problem.TSProblem;

import java.util.Random;

public class RandomAlgorithm extends TSAlgorithm{

    private Random rd;
    private int triesNumber;

    public RandomAlgorithm(TSProblem problem){
        super(problem);
        rd = new Random();
        triesNumber = 1000000;
    }

    public RandomAlgorithm(TSProblem problem, int triesNumber) {
        super(problem);
        rd = new Random();
        this.triesNumber = triesNumber;
    }

    @Override
    public Individual findSolution() {
        IFitness fit = getProblem().getFitnessCounter();

        Individual bestSolution = getProblem().getIndividual();
        fit.evaluate(bestSolution);

        for(int ii=0; ii<triesNumber; ii++){
            Individual competitor = getProblem().getIndividual();
            if( bestSolution.getFitness() > fit.evaluate(competitor)){
                bestSolution = competitor;
            }
        }
        return bestSolution;
    }
}
