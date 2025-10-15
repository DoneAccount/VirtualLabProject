import java.io.IOException;

public class Buoyancy extends Calculation {
    // Private Variables
    private String fluidType;
    private double fluidDensity;
    private double volume;
    private double buoyantForce;
    private double displacedFluidMass;

    // Previous Variables
    private String prevFluidType;
    private double prevFluidDensity;
    private double prevVolume;

    // Constructor
    public Buoyancy(double fluidDensity, double volume) {
        super();
        this.fluidType = this.prevFluidType = "Unknown";
        this.fluidDensity = this.prevFluidDensity = fluidDensity;
        this.volume = this.prevVolume = volume;
        // bf = d * v * G
        this.buoyantForce = fluidDensity * volume * GRAVITY;
        // dfm = d * v
        this.displacedFluidMass = fluidDensity * volume;
    }

    // Setter methods
    public void setFluidType(String fluidType) {
        this.fluidType = fluidType;
        setFluidDensity();
    }

    // Set fluid density based on the fluid type.
    public void setFluidDensity() {
        switch (fluidType) {
            case "Water" -> this.fluidDensity = 1000;
            case "Gasoline" -> this.fluidDensity = 660;
            case "Ethyl Alcohol" -> this.fluidDensity = 790;
            case "Mercury" -> this.fluidDensity = 1355;
        }
    }

    public void setFluidDensity(double fluidDensity) {
        this.fluidDensity = fluidDensity;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    // Getter methods

    public double getBuoyantForce() {
        return buoyantForce;
    }

    public double getDisplacedFluidMass() {
        return displacedFluidMass;
    }

    // Overridden Abstract Methods
    @Override
    public void confirmValues() throws IOException {
        // Calculate fluid density.
        setFluidDensity();

        System.out.printf("Fluid Type: %s%n", fluidType);
        System.out.printf("Fluid Density: %.2f kg/m^3%n", fluidDensity);
        System.out.printf("Volume: %.2f m^3%n", volume);

        if (inputConfirmation("\nAre these values correct? [Y/N]: ")) {
            calculateAll();
        } else {
            fluidType = prevFluidType;
            fluidDensity = prevFluidDensity;
            volume = prevVolume;
            System.out.println("Cancelled!");
            Calculation.enter();
        }
        Calculation.clear();
    }

    @Override
    public void calculateAll() {
        prevFluidType = fluidType;
        prevFluidDensity = fluidDensity;
        prevVolume = volume;
        this.buoyantForce = fluidDensity * volume * GRAVITY;
        this.displacedFluidMass = fluidDensity * volume;
    }

    // Print Buoyancy
    public void printBuoyancy() {
        System.out.printf("Fluid Type: %s%n", fluidType);
        System.out.printf("Fluid Density: %.2f kg/m^3%n", fluidDensity);
        System.out.printf("Volume: %.2f m^3%n", volume);
        System.out.printf("Buoyant Force: %.2f N%n", buoyantForce);
        System.out.printf("Displaced Fluid Mass: %.2f kg%n", displacedFluidMass);
    }
}
