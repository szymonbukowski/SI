import loader.Loader;
import individual.Individual;

import java.util.ArrayList;

public class Main {

    public static void main(String args[]){

        Loader loader = new Loader();
//        loader.loadByFileName("ali535.tsp");
//        loader.loadByFileName("berlin11_modified.tsp");
        loader.loadByFileName("berlin52.tsp");
//        loader.loadByFileName("fl417.tsp");
//        loader.loadByFileName("kroA100.tsp");
//        loader.loadByFileName("kroA150.tsp");
//        loader.loadByFileName("kroA200.tsp");
//        loader.loadByFileName("pr2392.tsp");
        loader.print();
        double[][] distance = loader.createDistanceMatrix();

        ArrayList<Individual> individuals = new ArrayList<>();
        for(int ii=0; ii<100; ii++){
            individuals.add(new Individual(loader.DIMENSION));
        }
        for(Individual i: individuals){
            System.out.println(i);
            System.out.println(i.fittnes(distance));
        }



    }
}
