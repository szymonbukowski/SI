package geneticOperators.mutation;

import individual.Individual;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class InversionMutation implements IMutation {

    Random rd;

    @Override
    public Individual mutate(Individual individual) {
        int size = individual.getGenome().size();
        int from = rd.nextInt(size-2);
        int to = rd.nextInt(size -2);

        ArrayList genome = individual.getGenome();
        int steps = 0;
        for(int ii = from; ii!=to; ii = (ii+1)%size){

        }

    }


}
