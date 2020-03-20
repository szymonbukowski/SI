package individual;

import java.util.ArrayList;

public class Individual implements Comparable<Individual>{

    private ArrayList<Integer> genome;
    private double fitness;

    public Individual(){
        genome = new ArrayList<>();
    }

    public Individual(ArrayList<Integer> genome) {
        this.genome = genome;
    }

    public Individual(Individual other){
        this.genome = new ArrayList<>(other.genome);
        this.fitness = other.fitness;
    }

    public ArrayList<Integer> getGenome() {
        return genome;
    }

    public void setGenome(ArrayList<Integer> genome) {
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
        for(Integer i: genome){
            res.append(i).append('-');
        }

        return res.toString();
    }
}
