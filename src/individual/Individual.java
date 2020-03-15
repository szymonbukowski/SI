package individual;

import java.util.ArrayList;

public class Individual<T> implements Comparable<Individual>{

    private ArrayList<T> genome;
    private double fitness;

    public Individual(){
        genome = new ArrayList<>();
    }

    public Individual(ArrayList<T> genome) {
        this.genome = genome;
    }

    public ArrayList<T> getGenome() {
        return genome;
    }

    public void setGenome(ArrayList<T> genome) {
        this.genome = genome;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    @Override
    public int compareTo(Individual o) {
        return (int)(o.getFitness() - fitness);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Individual: ");
        res.append("\n").append("fittnes: ").append(fitness);
        res.append("\n").append("genome: ");
        for(T t: genome){
            res.append(t).append('-');
        }

        return res.toString();
    }
}
