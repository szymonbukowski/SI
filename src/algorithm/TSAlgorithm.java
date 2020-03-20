package algorithm;

import individual.Individual;
import problem.TSProblem;

public abstract class TSAlgorithm{

    private TSProblem problem;


    public TSAlgorithm(TSProblem problem) {
        this.problem = problem;

    }

    public TSProblem getProblem() {
        return problem;
    }

    public void setProblem(TSProblem problem) {
        this.problem = problem;
    }

    public abstract Individual findSolution();
}
