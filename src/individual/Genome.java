package individual;

import java.util.ArrayList;

public class Genome<T> {
    private ArrayList<T> genes;

    public Genome(){
        genes = new ArrayList<>();
    }

    public Genome(ArrayList<T> genes) {

        this.genes = genes;
    }

    public void setGenes(ArrayList<T> genes) {
        this.genes = genes;
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
