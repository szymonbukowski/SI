package geneticOperators.crossover;

import individual.Individual;

import java.util.ArrayList;
import java.util.Random;

public class OXCrossover implements ICrossover{

    private Random rd;
    private int crossBeginning;
    private int crossEnd;

    public OXCrossover() {
        this.rd = new Random();
    }

    @Override
    public Individual crossover(Individual lhs, Individual rhs) {
        ArrayList<Integer> lhs_gen = new ArrayList<>(lhs.getGenome());
        ArrayList<Integer> rhs_gen = new ArrayList<>(rhs.getGenome());

        initCrossingPoints(lhs_gen.size());

        ArrayList<Integer> child_gen = getChildGenom(lhs_gen, rhs_gen, crossBeginning, crossEnd);
        return new Individual(child_gen);
    }

    private void initCrossingPoints(int size){
        crossBeginning = rd.nextInt(size);
        crossEnd = rd.nextInt(size);

        while(crossBeginning == crossEnd){
            crossEnd = rd.nextInt(size);
        }
        if(crossBeginning > crossEnd){
            int temp = crossBeginning;
            crossBeginning = crossEnd;
            crossEnd = temp;
        }
    }

    private ArrayList<Integer> getChildGenom(ArrayList<Integer> lhs_gen, ArrayList<Integer> rhs_gen, int cxbegin, int cxend){
        ArrayList<Integer> subgenom = new ArrayList<>(lhs_gen.subList(cxbegin, cxend));
        rhs_gen.removeAll(subgenom);
        ArrayList<Integer> childGenom = new ArrayList<>(lhs_gen.size());
        childGenom.addAll(rhs_gen);
        childGenom.addAll(cxbegin, subgenom);

        return childGenom;
    }
}
