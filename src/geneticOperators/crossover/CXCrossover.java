package geneticOperators.crossover;

import individual.Individual;

import java.util.ArrayList;

public class CXCrossover implements ICrossover {

    @Override
    public Individual crossover(Individual lhs, Individual rhs) {

        ArrayList<Integer> lhs_gen = lhs.getGenome();
        ArrayList<Integer> rhs_gen = rhs.getGenome();
        System.out.println("before - " + rhs_gen.size());
        int size = lhs.getGenome().size();
        ArrayList<Integer> cycleIndexes = findCycle(lhs_gen, rhs_gen, 0);
        System.out.println("after - " + rhs_gen.size());
        ArrayList<Integer> genome = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if(cycleIndexes.contains(i)){
                genome.add(lhs_gen.get(i));
            }else{
                genome.add(rhs_gen.get(i));
            }
        }
        return new Individual(genome);
    }

    private ArrayList<Integer> findCycle(ArrayList<Integer> lhs_gen, ArrayList<Integer> rhs_gen, int startIndex){

        boolean isCycleClosed = false;

        ArrayList<Integer> cycleIndexes = new ArrayList<>();
        cycleIndexes.add(startIndex);

        int startValue = lhs_gen.get(startIndex);
        int actIndex = startIndex;
        int actVal = rhs_gen.get(actIndex);

        while(!isCycleClosed){

            actIndex = lhs_gen.indexOf(actVal);
            cycleIndexes.add(actIndex);
            actVal = rhs_gen.get(actIndex);

            if(startValue == actIndex){
                isCycleClosed = true;
            }
        }
        return cycleIndexes;
    }

}
