package geneticOperators.crossover;

import individual.Individual;

public interface ICrossover {
    Individual crossover(Individual lhs, Individual rhs);
}
