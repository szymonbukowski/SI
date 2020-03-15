package geneticOperators.selection;

import individual.Individual;

import java.util.ArrayList;

public interface ISelection {
    public Individual select(ArrayList<Individual> population);
}
