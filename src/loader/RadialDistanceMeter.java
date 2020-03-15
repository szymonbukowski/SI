package loader;

public class RadialDistanceMeter implements IDistanceMeter {

    private double radius = 6378.0;

    public RadialDistanceMeter(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getDistance(Node lhs, Node rhs) {

        double lhs_lat = Math.toRadians(lhs.getPosX());
        double rhs_lat = Math.toRadians(rhs.getPosX());

        double delta_lat = Math.toRadians(rhs.getPosY()-lhs.getPosX());
        double delta_lng = Math.toRadians(rhs.getPosY()-lhs.getPosY());

        double a = Math.sin(delta_lat/2.0) * Math.sin(delta_lat/2.0) + Math.cos(lhs_lat) * Math.cos(rhs_lat) * Math.sin(delta_lng/2.0) * Math.sin(delta_lng/2.0);
        double c = 2.0 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));

        return radius * c;
    }
}
