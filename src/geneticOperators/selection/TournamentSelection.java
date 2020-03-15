package geneticOperators.selection;

import individual.Individual;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TournamentSelection implements ISelection {

    int tournamentSize;
    Random rd;

    @Override
    public Individual select(ArrayList<Individual> population) {
        ArrayList<Individual> tournament = new ArrayList<>();
        while(tournament.size() < tournamentSize){
            int competitorIndex = rd.nextInt(population.size());
            tournament.add(population.get(competitorIndex));
        }
        return Collections.min(tournament);
    }
}
