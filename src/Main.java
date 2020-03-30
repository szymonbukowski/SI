import algorithm.EvolutionaryAlgorithm;
import algorithm.GreedyAlgorithm;
import algorithm.RandomAlgorithm;
import geneticOperators.crossover.CXCrossover;
import geneticOperators.crossover.OXCrossover;
import geneticOperators.mutation.InversionMutation;
import geneticOperators.mutation.SwapMutation;
import geneticOperators.selection.TournamentSelection;
import loader.Loader;
import individual.Individual;
import problem.TSProblem;

public class Main {

    public static void main(String args[]){

        printHeader("Load file", 40, '#');
        Loader loader = new Loader();
//        loader.loadByFileName("ali535.tsp");
//        loader.loadByFileName("berlin11_modified.tsp");
//        loader.loadByFileName("berlin52.tsp");
//        loader.loadByFileName("fl417.tsp");
//        loader.loadByFileName("kroA100.tsp");
        loader.loadByFileName("kroA150.tsp");
//        loader.loadByFileName("kroA200.tsp");
//        loader.loadByFileName("pr2392.tsp");

        TSProblem problem = loader.getProblem();

//        printHeader("Random alg", 40, '#');
//        RandomAlgorithm randomAlgorithm = new RandomAlgorithm(problem, 1000);
//        Individual randomSolution = randomAlgorithm.findSolution();
//        System.out.println("Random:" + problem.getFitnessCounter().evaluate(randomSolution));
//
//        printHeader("Simple greedy alg", 40, '#');
        GreedyAlgorithm greedyAlgorithm = new GreedyAlgorithm(problem, 0);
//        Individual greedySolution = greedyAlgorithm.findSolution();
//        System.out.println("Greedy:" + problem.getFitnessCounter().evaluate(greedySolution));
//
        printHeader("Full greedy alg", 40, '#');
        Individual fullgreedySolution = greedyAlgorithm.fullSearch();
        System.out.println("FullGreedy:" + problem.getFitnessCounter().evaluate(fullgreedySolution));

        printHeader("GA CX gen", 40, '#');
        EvolutionaryAlgorithm ga = new EvolutionaryAlgorithm(problem, 1000, 3000, new TournamentSelection(300), new OXCrossover(),  new InversionMutation(), 0.7, 0.1);
        Individual geneticSolution = ga.findSolution();
        System.out.println("genetic solution:" + problem.getFitnessCounter().evaluate(geneticSolution));

    }

    public static void printHeader(String header, int width, char fillSign){
        int rest = width - header.length();
        StringBuilder res = new StringBuilder();

        for(int ii=0; ii<rest; ii++){
            res.append(fillSign);
        }

        res.append(' ').append(header).append(' ');

        for(int ii=0; ii<rest; ii++){
            res.append(fillSign);
        }
        System.out.println(res.toString());
    }

}
