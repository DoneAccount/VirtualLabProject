import java.io.IOException;

public class FreeFall extends Calculation {
    // Private Variables
    private double initialVelocity;
    private double initialHeight;
    private double timeOfFall;
    private double velocity; // Final velocity before reaching the ground.

    // Previous Variables;
    private double prevInitialVelocity;
    private double prevInitialHeight;

    // Constructor
    public FreeFall(double initialVelocity, double initialHeight) {
        super(); // Get GRAVITY constant
        this.initialVelocity = prevInitialVelocity = initialVelocity;
        this.initialHeight = prevInitialHeight = initialHeight;
        // Time of Fall = (-iv + sqrt((iv)^2 - 2 * -(G) * h)/G
        this.timeOfFall = (-initialVelocity + Math.sqrt(Math.pow(initialVelocity, 2) - 2 * -GRAVITY * initialHeight))/GRAVITY;
        // Final Velocity = v0 + g*t
        this.velocity = initialVelocity + (GRAVITY * timeOfFall);
    }

    // Setter Methods
    public void setInitialVelocity(double initialVelocity) {
        this.initialVelocity = initialVelocity;
    }

    public void setInitialHeight(double initialHeight) {
        this.initialHeight = initialHeight;
    }

    // Getter Methods

    public double getInitialVelocity() {
        return initialVelocity;
    }

    public double getInitialHeight() {
        return initialHeight;
    }

    public double getTimeOfFall() {
        return timeOfFall;
    }

    public double getVelocity() {
        return velocity;
    }

    // Overridden Abstract Methods
    @Override
    public void calculateAll() {
        prevInitialHeight = initialHeight;
        prevInitialVelocity = initialVelocity;
        this.timeOfFall = (-initialVelocity + Math.sqrt(Math.pow(initialVelocity, 2) - 2 * -GRAVITY * initialHeight))/GRAVITY;
        this.velocity = initialVelocity + (GRAVITY * timeOfFall);
    }

    @Override
    public void confirmValues() throws IOException {
        System.out.printf("Initial velocity: %.3f m/s%n", initialVelocity);
        System.out.printf("Height: %.3f m%n", initialHeight);

        if (inputConfirmation("\nAre these values correct? [Y/N]: ")) {
            calculateAll();
        } else {
            // Cancelling sets the initialHeight and initial velocity back to 0.
            initialVelocity = prevInitialVelocity;
            initialHeight = prevInitialHeight;
            System.out.println("Cancelled!");
            Calculation.enter();
        }
        Calculation.clear();
    }

    // Print FreeFall Method
    public void printFreeFall() {
        System.out.printf("Initial Velocity: %.3f m/s%n", initialVelocity);
        System.out.printf("Height: %.3f m%n", initialHeight);
        System.out.printf("Time of Fall: %.3f s%n", timeOfFall);
        System.out.printf("Final Velocity: %.3f m/s%n", velocity);
    }

}
