package fitness;

import individual.Individual;

public interface IFitness<T> {

    double countFitness(Individual<T> individual);
}
