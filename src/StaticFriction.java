import java.io.IOException;

public class StaticFriction extends Calculation {
    // Private Variables
    private double frictionCoefficient;
    private double normalForce;
    private double frictionForce;

    // Previous Variables
    private double prevFrictionCoefficient;
    private double prevNormalForce;

    // Constructor
    public StaticFriction(double frictionCoefficient, double normalForce) {
        this.frictionCoefficient = this.prevFrictionCoefficient = frictionCoefficient;
        this.normalForce = this.prevNormalForce = normalForce;
        // Friction force = n*fc
        this.frictionForce = normalForce * frictionCoefficient;
    }

    // Setter methods
    public void setFrictionCoefficient(double frictionCoefficient) {
        this.frictionCoefficient = frictionCoefficient;
    }

    public void setNormalForce(double normalForce) {
        this.normalForce = normalForce;
    }

    // Getter methods
    public double getFrictionForce() {
        return frictionForce;
    }

    // Overridden Abstract Methods
    @Override
    public void calculateAll() {
        frictionForce = frictionCoefficient*normalForce;
        prevFrictionCoefficient = frictionCoefficient;
        prevNormalForce = normalForce;
    }

    @Override
    public void confirmValues() throws IOException {
        System.out.printf("Friction Coefficient: %.3f%n", frictionCoefficient);
        System.out.printf("Normal Force: %.3f N%n", normalForce);

        if (inputConfirmation("\nAre these values correct? [Y/N]: ")) {
            calculateAll();
        } else {
            frictionCoefficient = prevFrictionCoefficient;
            normalForce = prevNormalForce;
            System.out.println("Cancelled!");
            Calculation.enter();
        }
        Calculation.clear();
    }

    // Print Static Friction force
    public void printStaticFriction() throws IOException {
        System.out.printf("Friction Coefficient: %.3f%n", frictionCoefficient);
        System.out.printf("Normal Force: %.3f N%n", normalForce);
        System.out.printf("Friction Force: %.3f N%n", frictionForce);
    }
}
