import algorithm.GreedyAlgorithm;
import algorithm.RandomAlgorithm;
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

        printHeader("Random alg", 40, '#');
        RandomAlgorithm randomAlgorithm = new RandomAlgorithm(problem, 2000000);
        Individual<Integer> randomSolution = randomAlgorithm.findSolution();
        System.out.println("Random:" + problem.getFitnessCounter().evaluate(randomSolution));

        printHeader("Simple greedy alg", 40, '#');
        GreedyAlgorithm greedyAlgorithm = new GreedyAlgorithm(problem, 0);
        Individual<Integer> greedySolution = greedyAlgorithm.findSolution();
        System.out.println("Greedy:" + problem.getFitnessCounter().evaluate(greedySolution));

        printHeader("Full greedy alg", 40, '#');
        Individual<Integer> fullgreedySolution = greedyAlgorithm.fullSearch();
        System.out.println("FullGreedy:" + problem.getFitnessCounter().evaluate(fullgreedySolution));

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
