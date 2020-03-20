package loader;

public class Euclides2dDistanceMeter implements IDistanceMeter{

    @Override
    public double getDistance(TSNode lhs, TSNode rhs) {
        return Math.sqrt( Math.pow(rhs.getPosX()-lhs.getPosX(), 2) + Math.pow(rhs.getPosY()-lhs.getPosY(), 2));
    }
}
