package geneticOperators.mutation;

import individual.Individual;

import java.util.ArrayList;
import java.util.Random;

public class SwapMutation implements IMutation {

    Random rd;

    public SwapMutation(){
        rd = new Random();
    }

    @Override
    public Individual mutate(Individual individual) {

        ArrayList<Integer> genome = individual.getGenome();

        int firstIndex = rd.nextInt(genome.size());
        int secondIndex = rd.nextInt(genome.size());

        while(firstIndex == secondIndex){
            secondIndex = rd.nextInt(genome.size());
        }
        swap(genome, firstIndex, secondIndex);

        return new Individual(genome);
    }

    private void swap(ArrayList<Integer> genome, int first, int second){
        int first_val = genome.get(first);
        int second_val = genome.get(second);

        genome.set(first, second_val);
        genome.set(second, first_val);
    }
}
