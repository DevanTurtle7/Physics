package centerOfMass;

public class Mass {
    private double mass;
    private Point position;

    public Mass(double mass, Point position) {
        this.mass = mass;
        this.position = position;
    }

    public double getMass() {
        return mass;
    }

    public Point getPosition() {
        return position;
    }
}
