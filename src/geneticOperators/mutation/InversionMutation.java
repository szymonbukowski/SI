package geneticOperators.mutation;

import individual.Individual;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class InversionMutation implements IMutation {

    Random rd;

    public InversionMutation(){
        rd = new Random();
    }

    @Override
    public Individual mutate(Individual individual) {
        int size = individual.getGenome().size();

        int from = rd.nextInt(size);
        int to = rd.nextInt(size);

        while(from == to){
            to = rd.nextInt(size);
        }
        if(to < from){
            int temp = to;
            to = from;
            from = temp;
        }

        ArrayList<Integer> genome = individual.getGenome();
        ArrayList<Integer> subgenome = new ArrayList<>(genome.subList(from, to));
        genome.removeAll(subgenome);

        Collections.reverse(subgenome);

        genome.addAll(from, subgenome);

        return new Individual(genome);
    }


}
