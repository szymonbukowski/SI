package fitness;

import individual.Individual;

public interface IFitness<T> {

    double evaluate(Individual<T> individual);
}
