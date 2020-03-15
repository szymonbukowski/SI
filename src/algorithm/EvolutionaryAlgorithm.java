package algorithm;

import fitness.IFitness;
import geneticOperators.crossover.ICrossover;
import geneticOperators.mutation.IMutation;
import geneticOperators.selection.ISelection;
import individual.Individual;
import problem.Problem;
import problem.TSProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class EvolutionaryAlgorithm extends TSAlgorithm{

    private int generationsNumber;
    private int populationSize;
    private IFitness fitness;
    private ISelection selection;
    private ICrossover crossover;
    private IMutation mutation;

    private Random rd;
    private double Px;
    private double Pm;
    private Individual bestIndividual;

    public EvolutionaryAlgorithm(TSProblem problem) {
        super(problem);
    }




    @Override
    public Individual<Integer> findSolution() {

        ArrayList<Individual> population = getPopulation(populationSize);
        evaluate(population);
        bestIndividual = population.get(0);

        ArrayList<Individual> nextPopulation = new ArrayList<>();
        for(int ii=0; ii<generationsNumber; ii++){

            while(nextPopulation.size()<populationSize){
                Individual p1 = selection.select(population);
                Individual p2 = selection.select(population);
                Individual o1;
                if(rd.nextGaussian() < Px){
                    o1 = crossover.crossover(p1, p2);
                }else{
                    o1 = p1;
                }
                if(rd.nextGaussian() < Pm){
                    mutation.mutate(o1);
                }
                fitness.evaluate(o1);
                if(bestIndividual.compareTo(o1) < 0){
                    bestIndividual = o1;
                }
            }
        }


        return bestIndividual;
    }

    private ArrayList<Individual> getPopulation(int populationSize){
        Problem problem = getProblem();

        ArrayList<Individual> population = new ArrayList<>();
        for (int i = 0; i < populationSize; i++) {
            population.add(problem.getIndividual());
        }
        return population;
    }

    private ArrayList<Individual> evaluate(ArrayList<Individual> population){
        IFitness fitness =getProblem().getFitnessCounter();
        for (Individual i: population) {
            fitness.evaluate(i);
        }
        Collections.sort(population);
        return population;
    }

}
