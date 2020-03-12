package algorithm;

import individual.Individual;
import problem.Problem;

public abstract class Algorithm {
    private Problem problem;

    public abstract Individual findSolution();
}
