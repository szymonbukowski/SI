package algorithm;

import fitness.IFitness;
import individual.Individual;
import problem.TSProblem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;

public class RandomAlgorithm extends TSAlgorithm{

    private Random rd;
    private int triesNumber;

    File outputFile;
    FileWriter fileWriter;

    public RandomAlgorithm(TSProblem problem){
        super(problem);
        rd = new Random();
        triesNumber = 1000000;
    }

    public RandomAlgorithm(TSProblem problem, int triesNumber) {
        super(problem);
        rd = new Random();
        this.triesNumber = triesNumber;
    }

    @Override
    public Individual findSolution() {
        IFitness fit = getProblem().getFitnessCounter();
        initFile();

        Individual bestSolution = getProblem().getIndividual();
        fit.evaluate(bestSolution);

        for(int ii=0; ii<triesNumber; ii++){
            if(ii == triesNumber/10){
                System.out.print("*10%*");
            }
            if(ii == 2 * triesNumber/10){
                System.out.print("*20%*");
            }
            if(ii == 3 * triesNumber/10){
                System.out.print("*30%*");
            }
            if(ii == 4 * triesNumber/10){
                System.out.print("*40%*");
            }
            if(ii == 5 * triesNumber/10){
                System.out.print("*50%*");
            }
            if(ii == 6 * triesNumber/10){
                System.out.print("*60%*");
            }
            if(ii == 7 * triesNumber/10){
                System.out.print("*70%*");
            }
            if(ii == 8 * triesNumber/10){
                System.out.print("*80%*");
            }
            if(ii == 9 * triesNumber/10){
                System.out.print("*90%*");
            }
            Individual competitor = getProblem().getIndividual();
            double competitorFitness =  fit.evaluate(competitor);
            saveResult(ii,competitorFitness);
            if( bestSolution.getFitness() > competitorFitness){
                bestSolution = competitor;
            }
        }
        System.out.print("*100%*\n");
        return bestSolution;
    }
    private boolean initFile(){
        LocalDateTime now = LocalDateTime.now();
        String filename = String.valueOf(now.getHour()) + String.valueOf(now.getMinute()) + String.valueOf(now.getSecond()) + "_"
                + getProblem().getPROBLEM_NAME() + "Random"  + "_tries" + triesNumber;
        outputFile = new File("logs/" + filename + ".csv");
        try {
            fileWriter = new FileWriter(outputFile);
            fileWriter.write("try;solution\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("BLAD odczytu pliku");
            return false;
        }
        return true;
    }
    private void saveResult(int id, double solution){
        try {

            fileWriter.write(String.valueOf(id) + ';');
            fileWriter.write(String.valueOf(solution) + ";\n");

            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
