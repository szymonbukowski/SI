package individual;

public class Individual<T> {

    private Genome<T> genome;
    private double fitness;

    public Individual(){
        genome = new Genome<>();
    }

    public Individual(Genome<T> genome) {
        this.genome = genome;
    }

    public Genome<T> getGenome() {
        return genome;
    }

    public void setGenome(Genome<T> genome) {
        this.genome = genome;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Individual: ");
        res.append("\n").append("fittnes: ").append(fitness);
        res.append("\n").append(genome);

        return res.toString();
    }
}
