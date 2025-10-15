import com.finalsproject.exceptions.InvalidMenuChoiceException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainMenu {
    // Functions
    // Function to print the menu options
    public static void menuMessage() {
        Calculation.clear();
        System.out.println("Welcome to the virtual lab! What would you like to calculate today?");
        System.out.println("\n[1] Free Fall");
        System.out.println("[2] Static Friction");
        System.out.println("[3] Projectile Motion");
        System.out.println("[4] Buoyancy");
        System.out.println("[5] Exit");
    }

    // Function for caught com.finalsproject.exceptions.InvalidMenuChoiceException
    public static void invalidMenuMessage() throws IOException {
        System.out.println("\nInvalid menu choice! Please try again.");
        Calculation.enter(); Calculation.clear();
    }

    // Function to simplify the menu input
    public static String menuInput(String message) throws IOException {
        // BufferedReader setup
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(message);
        return in.readLine();

    }

    // Menus and Submenus
    public static void mainMenu() throws IOException {
        boolean exit = false;

        // Object variables
        FreeFall ff = new FreeFall(0, 0);
        StaticFriction sf = new StaticFriction(0, 0);
        ProjectileMotion pm = new ProjectileMotion(0, 0, 1);
        Buoyancy b = new Buoyancy(0, 0);

        // Main loop body
        while (!exit) {
            menuMessage();

            String menuInput = menuInput("\nChoose a menu option: ");

            try {
                switch (menuInput) {
                    case "1" -> freeFallMenu(ff);
                    case "2" -> staticFrictionMenu(sf);
                    case "3" -> projectileMotionMenu(pm);
                    case "4" -> buoyancyMenu(b);
                    case "5" -> exit = exitMenu();
                    default -> throw new InvalidMenuChoiceException();
                }
            } catch (InvalidMenuChoiceException e) {
                invalidMenuMessage();
            }
        }

    }

    // Free Fall Submenu
    public static void freeFallMenu(FreeFall freeFall) throws IOException {
        boolean back = false;

        while (!back) {
            try {
                Calculation.clear();

                // Print the current values.
                System.out.println("Free Fall Values:");
                freeFall.printFreeFall();

                // Print the FreeFall Menu
                System.out.println("\n[1] Change Initial Velocity");
                System.out.println("[2] Change Initial Height");
                System.out.println("[3] Change All Values");
                System.out.println("[4] Exit");

                // Get user input
                String userInput = menuInput("\nChoose a menu option: ");
                Calculation.clear();

                // FreeFall submenu menu options
                switch (userInput) {
                    case "1" -> {
                        // Get input
                        double setInitialVelocityTo = Calculation.inputDouble("Set initial velocity to: ");

                        // Set and confirm values
                        freeFall.setInitialVelocity(setInitialVelocityTo);
                        freeFall.confirmValues();
                    }
                    case "2" -> {
                        // Get input
                        double setHeightTo = Calculation.inputDouble("Set initial height to: ");

                        // Set and confirm values
                        freeFall.setInitialHeight(setHeightTo);
                        freeFall.confirmValues();
                    }
                    case "3" -> {
                        // Get inputs
                        double setInitialVelocityTo = Calculation.inputDouble("Set initial velocity to: ");
                        double setHeightTo = Calculation.inputDouble("Set initial height to: ");

                        // Set and confirm values
                        freeFall.setInitialVelocity(setInitialVelocityTo);
                        freeFall.setInitialHeight(setHeightTo);
                        freeFall.confirmValues();
                    }
                    case "4" -> back = true;
                    default -> throw new InvalidMenuChoiceException();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InvalidMenuChoiceException e) {
                invalidMenuMessage();
            }
        }
    }

    // Static Friction Submenu
    public static void staticFrictionMenu(StaticFriction staticFriction) throws IOException {
        boolean exit = false;

        while (!exit) {
            Calculation.clear();

            // Print the current values.
            System.out.println("Static Friction Values:");
            staticFriction.printStaticFriction();

            // Print the StaticFriction Menu
            System.out.println("\n[1] Change Friction Coefficient");
            System.out.println("[2] Change Normal Force");
            System.out.println("[3] Change All Values");
            System.out.println("[4] Exit");

            // Get user input
            String userInput = menuInput("\nChoose a menu option: ");
            Calculation.clear();

            // StaticFriction submenu menu options
            try {
                switch (userInput) {
                    case "1" -> {
                        // Get inputs
                        double setFrictionCoefficientTo = Calculation.inputDouble("Set friction coefficient to: ");

                        // Set and confirm values
                        staticFriction.setFrictionCoefficient(setFrictionCoefficientTo);
                        staticFriction.confirmValues();
                    }
                    case "2" -> {
                        // Get inputs
                        double setNormalForceTo = Calculation.inputDouble("Set normal force to: ");

                        // Set and confirm values
                        staticFriction.setNormalForce(setNormalForceTo);
                        staticFriction.confirmValues();
                    }
                    case "3" -> {
                        // Get inputs
                        double setFrictionCoefficientTo = Calculation.inputDouble("Set friction coefficient to: ");
                        double setNormalForceTo = Calculation.inputDouble("Set normal force to: ");

                        // Set and confirm values
                        staticFriction.setFrictionCoefficient(setFrictionCoefficientTo);
                        staticFriction.setNormalForce(setNormalForceTo);
                        staticFriction.confirmValues();
                    }
                    case "4" -> exit = true;
                    default -> throw new InvalidMenuChoiceException();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InvalidMenuChoiceException e) {
                invalidMenuMessage();
            }
        }
    }

    // Projectile Motion Submenu
    public static void projectileMotionMenu(ProjectileMotion projectileMotion) throws IOException {
        boolean exit = false;

        while (!exit) {
            Calculation.clear();

            // Print the current values
            System.out.println("Projectile Motion Values:");
            projectileMotion.printProjectileMotion();

            // Print the ProjectileMotion menu
            System.out.println("\n[1] Change Initial Velocity");
            System.out.println("[2] Change Initial Height");
            System.out.println("[3] Change Angle of Launch");
            System.out.println("[4] Change All Values");
            System.out.println("[5] Exit");

            // Get user input
            String userInput = menuInput("\nChoose a menu option: ");
            Calculation.clear();

            // ProjectileMotion submenu menu options
            try {
                switch (userInput) {
                    case "1" -> {
                        // Get inputs
                        double setInitialVelocityTo = Calculation.inputDouble("Set initial velocity to: ");

                        // Set and confirm values
                        projectileMotion.setInitialVelocity(setInitialVelocityTo);
                        projectileMotion.confirmValues();
                    }
                    case "2" -> {
                        // Get inputs
                        double setInitialHeightTo = Calculation.inputDouble("Set initial height to: ");

                        // Set and confirm values
                        projectileMotion.setInitialHeight(setInitialHeightTo);
                        projectileMotion.confirmValues();
                    }
                    case "3" -> {
                        // Get inputs
                        double setAngleOfLaunchTo = Calculation.inputAngle("Set angle of launch to: ");

                        // Set and confirm values
                        projectileMotion.setAngleOfLaunch(Math.toRadians(setAngleOfLaunchTo));
                        projectileMotion.confirmValues();
                    }
                    case "4" -> {
                        // Get inputs
                        double setInitialVelocityTo = Calculation.inputDouble("Set initial velocity to: ");
                        double setInitialHeightTo = Calculation.inputDouble("Set initial height to: ");
                        double setAngleOfLaunchTo = Calculation.inputAngle("Set angle of launch to: ");

                        // Set and confirm values
                        projectileMotion.setInitialVelocity(setInitialVelocityTo);
                        projectileMotion.setInitialHeight(setInitialHeightTo);
                        projectileMotion.setAngleOfLaunch(Math.toRadians(setAngleOfLaunchTo));
                        projectileMotion.confirmValues();
                    }
                    case "5" -> exit = true;
                    default -> throw new InvalidMenuChoiceException();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InvalidMenuChoiceException e) {
                invalidMenuMessage();
            }
        }
    }

    // Buoyancy Submenu
    public static void buoyancyMenu(Buoyancy buoyancy) throws IOException {
        boolean exit = false;

        while (!exit) {
            Calculation.clear();

            // Print the current values
            System.out.println("Buoyancy Values:");
            buoyancy.printBuoyancy();

            // Print the Buoyancy menu
            System.out.println("\n[1] Change Fluid Type");
            System.out.println("[2] Change Fluid Density");
            System.out.println("[3] Change Fluid Volume");
            System.out.println("[4] Change All Values");
            System.out.println("[5] Exit");

            // Get user input
            String userInput = menuInput("\nChoose a menu option: ");
            Calculation.clear();

            // Buoyancy submenu menu options
            try {
                switch (userInput) {
                    case "1" -> {
                        fluidTypeSelection(buoyancy);
                    }
                    case "2" -> {
                        // Get input
                        double setFluidDensityTo = Calculation.inputDouble("Set fluid density to: ");

                        // Set and confirm value
                        buoyancy.setFluidDensity(setFluidDensityTo);
                        buoyancy.confirmValues();
                    }
                    case "3" -> {
                        // Get input
                        double setFluidVolumeTo = Calculation.inputDouble("Set fluid volume to: ");

                        // Set and confirm value
                        buoyancy.setVolume(setFluidVolumeTo);
                        buoyancy.confirmValues();
                    }
                    case "4" -> {
                        // Get inputs
                        String setFluidTypeTo = Calculation.inputString("Set fluid type to: ");
                        double setFluidDensityTo = Calculation.inputDouble("Set fluid density to: ");
                        double setFluidVolumeTo = Calculation.inputDouble("Set fluid volume to: ");

                        // Set and confirm values
                        buoyancy.setFluidType(setFluidTypeTo);
                        buoyancy.setFluidDensity(setFluidDensityTo);
                        buoyancy.setVolume(setFluidVolumeTo);
                        buoyancy.confirmValues();

                    }
                    case "5" -> exit = true;
                    default -> throw new InvalidMenuChoiceException();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InvalidMenuChoiceException e) {
                invalidMenuMessage();
            }
        }
    }

    // Buoyancy Select Fluid Type
    public static void fluidTypeSelection(Buoyancy buoyancy) throws IOException {
        boolean exit = false;

        do {
            // Print Fluid Type menu
            System.out.println("Choose a Fluid Type:");
            System.out.println("\n[1] Water");
            System.out.println("[2] Gasoline");
            System.out.println("[3] Ethyl Alcohol");
            System.out.println("[4] Mercury");
            System.out.println("[5] Custom Name");
            System.out.println("[6] Back");

            // Get user input
            String userInput = menuInput("\nChoose a menu option: ");
            Calculation.clear();

            try {
                switch (userInput) {
                    case "1" -> {
                        buoyancy.setFluidType("Water");
                    }
                    case "2" -> {
                        buoyancy.setFluidType("Gasoline");
                    }
                    case "3" -> {
                        buoyancy.setFluidType("Ethyl Alcohol");
                    }
                    case "4" -> {
                        buoyancy.setFluidType("Mercury");
                    }
                    case "5" -> {
                        String fluidTypeName = Calculation.inputString("Set a custom fluid type: ");
                        buoyancy.setFluidType(fluidTypeName);
                        Calculation.clear();
                    }
                    case "6" -> {
                        exit = true;
                    }
                    default -> throw new InvalidMenuChoiceException();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InvalidMenuChoiceException e) {
                invalidMenuMessage();
                continue;
            }

            if (!exit) {
                System.out.println("\nFluid type set!");
                Calculation.enter(); Calculation.clear();
                exit = true;
            }

            buoyancy.setFluidDensity();

        } while (!exit);
    }

    // Exit Submenu, returns boolean value.
    public static boolean exitMenu() throws IOException {
        boolean userInput = Calculation.inputConfirmation("Are you sure you want to exit the program? [Y/N]: ");

        if (userInput) {
            System.out.println("Thank you for using the program!");
            System.out.println("Made by:");
            System.out.println("\tAdvincula, Klyde Christian");
            System.out.println("\tBelinario Kurt");
            System.out.println("\tCunanan, Renz Edric");
            System.out.println("\tYambao, Chyle");
        }
        return userInput;
    }

    // Main Method
    public static void main(String[] args) throws IOException {
        // Menu
        mainMenu();
    }
}
