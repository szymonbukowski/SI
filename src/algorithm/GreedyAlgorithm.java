package algorithm;

import fitness.IFitness;
import individual.Individual;
import problem.TSProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GreedyAlgorithm extends TSAlgorithm {

    ArrayList<Integer> notVisited;
    Random rd;
    Integer startPoint;

    public GreedyAlgorithm(TSProblem problem){
        super(problem);
        notVisited = new ArrayList<>();
        rd = new Random();
        startPoint = null;
    }


    public GreedyAlgorithm(TSProblem problem, Integer startPoint) {
        super(problem);
        notVisited = new ArrayList<>();
        rd = new Random();
        this.startPoint = startPoint;
    }

    private void initNotVisited(){
        notVisited.clear();
        int size = getProblem().getDIMENSION();
        for(int ii=0; ii<size; ii++){
            notVisited.add(ii);
        }
        Collections.shuffle(notVisited);
    }

    private void visit(Integer nextStop, ArrayList<Integer> notVisited, ArrayList<Integer> visited){
        notVisited.remove(nextStop);
        visited.add(nextStop);
    }


    public ArrayList<Integer> getNotVisited() {
        return notVisited;
    }

    public void setNotVisited(ArrayList<Integer> notVisited) {
        this.notVisited = notVisited;
    }

    public Random getRd() {
        return rd;
    }

    public void setRd(Random rd) {
        this.rd = rd;
    }

    public Integer getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Integer startPoint) {
        this.startPoint = startPoint;
    }

    public Individual<Integer> fullSearch(){
        IFitness fit = getProblem().getFitnessCounter();
        Individual<Integer> bestSolution = getProblem().getIndividual();
        fit.evaluate(bestSolution);

        ArrayList<Integer> notTested = new ArrayList<>();
        for (int ii = 0; ii < getProblem().getDIMENSION(); ii++) {
            notTested.add(ii);
        }
        for(Integer i: notTested){
            setStartPoint(i);
            Individual<Integer> res = findSolution();
            if(bestSolution.getFitness() > fit.evaluate(res)){
                bestSolution = res;
            }
        }
        return bestSolution;
    }

    @Override
    public Individual<Integer> findSolution() {
        initNotVisited();
        double[][] distances = getProblem().getDistanceMatrix();
        ArrayList<Integer> genome = new ArrayList<>();

        if(startPoint == null){
            startPoint = rd.nextInt(getProblem().getDIMENSION());
        }
        visit(startPoint, notVisited, genome);
        int actual = startPoint;

        for(int ii=0; ii<getProblem().getDIMENSION(); ii++){
            int nextStop =0;
            double closestDistance = Integer.MAX_VALUE;

            for(Integer i: notVisited){
                if(closestDistance > distances[actual][i]){
                    nextStop = i;
                    closestDistance = distances[actual][i];
                }
            }

            visit(nextStop, notVisited, genome);
            actual = nextStop;
        }
        return new Individual<>(genome);
    }
}
