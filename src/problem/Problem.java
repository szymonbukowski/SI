package problem;

import fitness.IFitness;

public class Problem {

    private String PROBLEM_NAME;
    private String PROBLEM_TYPE;
    private String PROBLEM_COMMENT;

    private IFitness fitnessCounter;

    public Problem(){

    }

    public Problem(String PROBLEM_NAME, String PROBLEM_TYPE, String PROBLEM_COMMENT) {
        this.PROBLEM_NAME = PROBLEM_NAME;
        this.PROBLEM_TYPE = PROBLEM_TYPE;
        this.PROBLEM_COMMENT = PROBLEM_COMMENT;
    }

    public String getPROBLEM_NAME() {
        return PROBLEM_NAME;
    }

    public void setPROBLEM_NAME(String PROBLEM_NAME) {
        this.PROBLEM_NAME = PROBLEM_NAME;
    }

    public String getPROBLEM_TYPE() {
        return PROBLEM_TYPE;
    }

    public void setPROBLEM_TYPE(String PROBLEM_TYPE) {
        this.PROBLEM_TYPE = PROBLEM_TYPE;
    }

    public String getPROBLEM_COMMENT() {
        return PROBLEM_COMMENT;
    }

    public void setPROBLEM_COMMENT(String PROBLEM_COMMENT) {
        this.PROBLEM_COMMENT = PROBLEM_COMMENT;
    }

    public IFitness getFitnessCounter() {
        return fitnessCounter;
    }

    public void setFitnessCounter(IFitness fitnessCounter) {
        this.fitnessCounter = fitnessCounter;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "PROBLEM_NAME='" + PROBLEM_NAME + '\'' +
                ", PROBLEM_TYPE='" + PROBLEM_TYPE + '\'' +
                ", PROBLEM_COMMENT='" + PROBLEM_COMMENT + '\'' +
                '}';
    }
}
