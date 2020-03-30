package algorithm;

import fitness.IFitness;
import geneticOperators.crossover.ICrossover;
import geneticOperators.mutation.IMutation;
import geneticOperators.selection.ISelection;
import individual.Individual;
import problem.Problem;
import problem.TSProblem;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    private double averageIndividualFitness;
    private double worstIndividualFitness;

    File output;

    public EvolutionaryAlgorithm(TSProblem problem) {
        super(problem);
    }

    public EvolutionaryAlgorithm(TSProblem problem, int generationsNumber, int populationSize, ISelection selection, ICrossover crossover, IMutation mutation, double px, double pm) {
        super(problem);
        this.generationsNumber = generationsNumber;
        this.populationSize = populationSize;
        this.fitness = problem.getFitnessCounter();
        this.selection = selection;
        this.crossover = crossover;
        this.mutation = mutation;
        this.rd = new Random();
        Px = px;
        Pm = pm;
    }

    @Override
    public Individual findSolution() {

        ArrayList<Individual> population = getPopulation(populationSize);
        bestIndividual = population.get(0);
        fitness.evaluate(bestIndividual);
        evaluate(population);

        ArrayList<Individual> nextPopulation = new ArrayList<>();
        for(int ii=0; ii<generationsNumber; ii++){

            while(nextPopulation.size()<populationSize){
                Individual p1 = selection.select(population);
                Individual p2 = selection.select(population);
                Individual o1;
                if(rd.nextGaussian() < Px){
                    o1 = crossover.crossover(p1, p2);
                }else{
                    o1 = new Individual(p1);
                }
                if(rd.nextGaussian() < Pm){
                    mutation.mutate(o1);
                }
                fitness.evaluate(o1);
                if(bestIndividual.compareTo(o1) > 0){
                    bestIndividual = o1;
                }
                nextPopulation.add(o1);
            }
            population = nextPopulation;
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
        averageIndividualFitness = 0.0;
        for (Individual i: population) {
            fitness.evaluate(i);
            if(bestIndividual.getFitness() > i.getFitness()){
                bestIndividual = i;
            }
            if(worstIndividualFitness < i.getFitness()){
                worstIndividualFitness = i.getFitness();
            }
            averageIndividualFitness += i.getFitness();
        }
        return population;
    }
    public boolean initFile(){
        String filename = getProblem().getPROBLEM_NAME() + "_" + LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute();
        output = new File("logs/" + filename + ".csv");
        return true;

    }
    public void saveToFile(){

    }
    public int getGenerationsNumber() {
        return generationsNumber;
    }

    public void setGenerationsNumber(int generationsNumber) {
        this.generationsNumber = generationsNumber;
    }

    public int getPopulationSize() {
        return populationSize;
    }

    public void setPopulationSize(int populationSize) {
        this.populationSize = populationSize;
    }

    public IFitness getFitness() {
        return fitness;
    }

    public void setFitness(IFitness fitness) {
        this.fitness = fitness;
    }

    public ISelection getSelection() {
        return selection;
    }

    public void setSelection(ISelection selection) {
        this.selection = selection;
    }

    public ICrossover getCrossover() {
        return crossover;
    }

    public void setCrossover(ICrossover crossover) {
        this.crossover = crossover;
    }

    public IMutation getMutation() {
        return mutation;
    }

    public void setMutation(IMutation mutation) {
        this.mutation = mutation;
    }

    public double getPx() {
        return Px;
    }

    public void setPx(double px) {
        Px = px;
    }

    public double getPm() {
        return Pm;
    }

    public void setPm(double pm) {
        Pm = pm;
    }

    public Individual getBestIndividual() {
        return bestIndividual;
    }

    public void setBestIndividual(Individual bestIndividual) {
        this.bestIndividual = bestIndividual;
    }
}
