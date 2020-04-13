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
import problem.Problem;
import problem.TSProblem;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Random;

public class Main {

    private static void random(TSProblem problem){
        printHeader("Random alg", 40, '#');
        RandomAlgorithm randomAlgorithm = new RandomAlgorithm(problem, 10000);
        Individual randomSolution = randomAlgorithm.findSolution();
        System.out.println("Random:" + problem.getFitnessCounter().evaluate(randomSolution));
    }

    private static void greedy(TSProblem problem){
        GreedyAlgorithm greedyAlgorithm = new GreedyAlgorithm(problem, 0);
//        printHeader("Simple greedy alg", 40, '#');
//        Individual greedySolution = greedyAlgorithm.findSolution();
//        System.out.println("Greedy:" + problem.getFitnessCounter().evaluate(greedySolution));

        printHeader("Full greedy alg", 40, '#');
        Individual fullgreedySolution = greedyAlgorithm.fullSearch();
        System.out.println("FullGreedy:" + problem.getFitnessCounter().evaluate(fullgreedySolution));
    }
    private static void population_Experiment(TSProblem problem){
        ga_population(problem, 100);
        ga_population(problem, 200);
        ga_population(problem, 400);
        ga_population(problem, 800);
        ga_population(problem, 1600);
        ga_population(problem, 3200);
        ga_population(problem, 6400);
    }
    private static void ga_population(TSProblem problem, int experimentalParam){
        printHeader("GA  gen", 40, '#');
        EvolutionaryAlgorithm ga = new EvolutionaryAlgorithm(problem, 300, experimentalParam, new TournamentSelection(experimentalParam/10), new OXCrossover(),  new InversionMutation(), 0.65, 0.15);
        Individual geneticSolution = ga.findSolution();
        System.out.println("genetic solution popsize(" + experimentalParam + "): " + problem.getFitnessCounter().evaluate(geneticSolution));
        System.out.println(geneticSolution);
    }
    private static void tournament_Experiment(TSProblem problem){
        ga_tournament(problem, 1);
        ga_tournament(problem, 30);
        ga_tournament(problem, 60);
        ga_tournament(problem, 90);
        ga_tournament(problem, 180);
        ga_tournament(problem, 210);
        ga_tournament(problem, 240);
    }
    private static void ga_tournament(TSProblem problem, int experimentalParam){
        printHeader("GA  gen", 40, '#');
        EvolutionaryAlgorithm ga = new EvolutionaryAlgorithm(problem, 300, 300, new TournamentSelection(experimentalParam), new OXCrossover(),  new InversionMutation(), 0.65, 0.15);
        Individual geneticSolution = ga.findSolution();
        System.out.println("genetic solution tournament(" + experimentalParam + "): " + problem.getFitnessCounter().evaluate(geneticSolution));
        System.out.println(geneticSolution);
    }
    private static void px_Experiment(TSProblem problem){
        ga_px(problem, 0.0);
        ga_px(problem, 0.2);
        ga_px(problem, 0.4);
        ga_px(problem, 0.6);
        ga_px(problem, 0.8);
        ga_px(problem, 1.0);
    }
    private static void ga_px(TSProblem problem, double experimentalParam){
        printHeader("GA  gen", 40, '#');
        EvolutionaryAlgorithm ga = new EvolutionaryAlgorithm(problem, 300, 300, new TournamentSelection(30), new OXCrossover(),  new InversionMutation(), experimentalParam, 0.00);
        Individual geneticSolution = ga.findSolution();
        System.out.println("genetic solution cross prob(" + experimentalParam + "): " + problem.getFitnessCounter().evaluate(geneticSolution));
        System.out.println(geneticSolution);
    }
    private static void pm_Experiment(TSProblem problem){
        ga_pm(problem, 0.05);
        ga_pm(problem, 0.10);
        ga_pm(problem, 0.15);
        ga_pm(problem, 0.20);
        ga_pm(problem, 0.40);
        ga_pm(problem, 0.60);
        ga_pm(problem, 0.80);
        ga_pm(problem, 0.90);
        ga_pm(problem, 0.95);
    }
    private static void ga_pm(TSProblem problem, double experimentalParam){
        printHeader("GA  gen", 40, '#');
        EvolutionaryAlgorithm ga = new EvolutionaryAlgorithm(problem, 300, 300, new TournamentSelection(30), new OXCrossover(),  new InversionMutation(), 0.0, experimentalParam);
        Individual geneticSolution = ga.findSolution();
        System.out.println("genetic solution mutation prob(" + experimentalParam + "): " + problem.getFitnessCounter().evaluate(geneticSolution));
        System.out.println(geneticSolution);
    }
    private static void ga(TSProblem problem){
        printHeader("GA  gen", 40, '#');
        EvolutionaryAlgorithm ga = new EvolutionaryAlgorithm(problem, 3000, 300, new TournamentSelection(30), new OXCrossover(),  new InversionMutation(), 0.82, 0.85);
        Individual geneticSolution = ga.findSolution();
        System.out.println("genetic solution: " + problem.getFitnessCounter().evaluate(geneticSolution));
        System.out.println(geneticSolution);
    }

    public static void main(String args[]){

        printHeader("Load file", 40, '#');
        Loader loader = new Loader();
//        loader.loadByFileName("ali535.tsp");
//        loader.loadByFileName("berlin11_modified.tsp");
//        loader.loadByFileName("berlin52.tsp");
//        loader.loadByFileName("fl417.tsp");
//        loader.loadByFileName("kroA100.tsp");
//        loader.loadByFileName("kroA150.tsp");
        loader.loadByFileName("kroA200.tsp");
//        loader.loadByFileName("pr2392.tsp");
//        loader.loadByFileName("gr666.tsp");
//        loader.loadByFileName("pr2392.tsp");
//        loader.loadByFileName("nrw1379.tsp");

        TSProblem problem = loader.getProblem();
//
//        random(problem);
//        greedy(problem);
//        ga(problem);
        px_Experiment(problem);

    }

    public static void printHeader(String header, int width, char fillSign){
        int side = width - header.length() - 2;
        StringBuilder res = new StringBuilder();

        for(int ii=0; ii<side; ii++){
            res.append(fillSign);
        }

        res.append(' ').append(header).append(' ');

        for(int ii=0; ii<side; ii++){
            res.append(fillSign);
        }
        System.out.println(res.toString());
    }

}
