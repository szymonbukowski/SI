package loader;

public class TSNode {

    private int ID;
    private double posX;
    private double posY;

    public TSNode(){

    }

    public TSNode(int ID, double posX, double posY) {
        this.ID = ID;
        this.posX = posX;
        this.posY = posY;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    @Override
    public String toString() {
        return "Loader.Node{" +
                "ID=" + ID +
                ", " + posX +
                ", " + posY +
                '}';
    }
}
