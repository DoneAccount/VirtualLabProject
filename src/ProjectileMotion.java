import java.io.IOException;

public class ProjectileMotion extends Calculation {
    // Private Variables
    private double initialVelocity;
    private double initialHeight;
    private double angleOfLaunch;
    private double timeOfFlight;
    private double distance;
    private double maxHeight;

    // Previous Variables
    private double prevInitialVelocity;
    private double prevInitialHeight;
    private double prevAngleOfLaunch;

    // Constructor
    public ProjectileMotion(double initialVelocity, double initialHeight, double angleOfLaunch) {
        super();
        this.initialVelocity = this.prevInitialVelocity = initialVelocity;
        this.initialHeight = this.prevInitialHeight = initialHeight;
        this.angleOfLaunch = this.prevAngleOfLaunch = Math.toRadians(angleOfLaunch); // Convert into pi radians
        // t = (iV*sin(a)+sqrt.((iV*sin(a))^2+(2Gh)))/G
        this.timeOfFlight = (initialVelocity*Math.sin(this.angleOfLaunch)+Math.sqrt(Math.pow(initialVelocity*Math.sin(this.angleOfLaunch), 2) + (2*GRAVITY*initialHeight)))/GRAVITY;
        // d = iV*sin(a)*t
        this.distance = initialVelocity*Math.cos(this.angleOfLaunch)*timeOfFlight;
        // h max = iV^2*sin^2(a)
        this.maxHeight = initialHeight+((Math.pow(initialVelocity, 2)*Math.pow(Math.sin(this.angleOfLaunch), 2))/2*GRAVITY);
    }

    // Setter methods
    public void setInitialVelocity(double initialVelocity) {
        this.initialVelocity = initialVelocity;
    }

    public void setInitialHeight(double initialHeight) {
        this.initialHeight = initialHeight;
    }

    public void setAngleOfLaunch(double angleOfLaunch) {
        this.angleOfLaunch = angleOfLaunch;
    }

    // Getter methods
    public double getTimeOfFlight() {
        return timeOfFlight;
    }

    public double getDistance() {
        return distance;
    }

    public double getMaxHeight() {
        return maxHeight;
    }

    // Overridden Abstract Methods
    @Override
    public void calculateAll() {
        prevInitialVelocity = initialVelocity;
        prevInitialHeight = initialHeight;
        prevAngleOfLaunch = angleOfLaunch;
        this.timeOfFlight = (initialVelocity*Math.sin(angleOfLaunch)+Math.sqrt(Math.pow(initialVelocity*Math.sin(this.angleOfLaunch), 2) + (2*GRAVITY*initialHeight)))/GRAVITY;
        this.distance = initialVelocity*Math.cos(angleOfLaunch)*timeOfFlight;
        this.maxHeight = initialHeight+((Math.pow(initialVelocity, 2)*Math.pow(Math.sin(angleOfLaunch), 2))/2*GRAVITY);
    }

    @Override
    public void confirmValues() throws IOException {
        System.out.printf("Initial Velocity: %.3f m/s%n", initialVelocity);
        System.out.printf("Initial Height: %.3f m%n", initialHeight);
        System.out.printf("Angle of Launch: %.3f deg%n", Math.toDegrees(angleOfLaunch));
        System.out.printf("%.3f%n", angleOfLaunch);

        if (inputConfirmation("\nAre these values correct? [Y/N]: ")) {
            calculateAll();
        } else {
            initialVelocity = prevInitialVelocity;
            initialHeight = prevInitialHeight;
            angleOfLaunch = prevAngleOfLaunch;
            System.out.println("Cancelled!");
            Calculation.enter();
        }
        Calculation.clear();
    }

    // Print Projectile Motion Method
    public void printProjectileMotion() {
        System.out.printf("Initial Velocity: %.3f m/s%n", initialVelocity);
        System.out.printf("Initial Height: %.3f m%n", initialHeight);
        System.out.printf("Angle of Launch: %.3f deg%n", Math.toDegrees(angleOfLaunch));
        System.out.printf("Time of Flight: %.3f s%n", timeOfFlight);
        System.out.printf("Distance Travelled: %.3f m%n", distance);
        System.out.printf("Maximum Height: %.3f m%n", maxHeight);
    }
}
