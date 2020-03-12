package individual;

import java.util.ArrayList;

public class Genome<T> {
    private int size;
    private ArrayList<T> genes;

    public Genome(){
        genes = new ArrayList<>();
        size = genes.size();
    }

    public Genome(ArrayList<T> genes) {
        size = genes.size();
        this.genes = genes;
    }

    //public boolean addGene(T gene){} TODO zrobic metody ukrywajace ArrayListe
    public ArrayList<T> getGenes(){
        return this.genes;
    }
    public void setGenes(ArrayList<T> genes) {
        this.genes = genes;
        size = this.genes.size();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Genome: ");
        for(T t: genes){
            res.append(t).append("-");
        }
        return res.toString();
    }
}
