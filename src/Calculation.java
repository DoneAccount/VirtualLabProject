import com.finalsproject.exceptions.EmptyStringException;
import com.finalsproject.exceptions.InvalidAngleException;
import com.finalsproject.exceptions.InvalidConfirmation;
import com.finalsproject.exceptions.NegativeNumberException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class Calculation {
    // BufferedReader Setup for the public input methods.
    public static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    // Constant to be used for every calculation.
    public final double GRAVITY = 9.80665;

    // Abstract methods for overriding.
    public abstract void calculateAll();
    public abstract void confirmValues() throws IOException;

    // Public static methods that may be used for all classes
    // Double input method with error handling
    public static double inputDouble(String message) throws IOException {
        while (true) { // Loop
            try {
                System.out.print(message);
                double returnValue = Double.parseDouble(in.readLine());

                if (returnValue < 0) { // Catch negative numbers
                    throw new NegativeNumberException();
                }

                return returnValue;
            } catch (NegativeNumberException e) {
                System.out.println("Number must be 0 or greater.");
                enter();clear();
            } catch (NumberFormatException e) {
                System.out.println("Number is invalid.");
                enter();clear();
            } catch (IOException e) {
                throw new IOException("Input/Output Exception occurred!");
            }
        }
    }

    // String input method
    public static String inputString(String message) throws IOException {
        while (true) { // Loop
            try {
                System.out.print(message);
                String returnValue = in.readLine().trim();

                if (returnValue.isEmpty()) { // Catch empty strings
                    throw new EmptyStringException();
                }

                return returnValue;
            } catch (EmptyStringException e) {
                System.out.println("You cannot submit an empty value.");
                enter();clear();
            } catch (IOException e) {
                throw new IOException("Input/Output Exception occurred!");
            }
        }
    }

    // Angle input method
    public static double inputAngle(String message) throws IOException {
        while (true) { // Loop
            try {
                System.out.print(message);
                double returnValue = Double.parseDouble(in.readLine());

                if (returnValue <= 0 || returnValue >= 90) { // Catch invalid angles
                    throw new InvalidAngleException();
                }

                return returnValue;
            } catch (InvalidAngleException e) {
                System.out.println("Angle must be inbetween 0 and 90.");
                enter();clear();
            }
        }
    }

    // Y/N Confirmation input method
    public static boolean inputConfirmation(String message) throws IOException {
        while (true) {
            try {
                System.out.print(message);
                String confirmationInput = in.readLine();

                return switch (confirmationInput.toUpperCase()) {
                    case "Y" -> true;
                    case "N" -> false;
                    default -> throw new InvalidConfirmation();
                };
            } catch (InvalidConfirmation e) {
                System.out.println("Confirmation is invalid.");
                enter();clear();
            }
        }
    }

    // Decorative public static methods

    public static void clear() { // Clears the console for better visibility.
        for (int i = 0; i < 40; i++) {
            System.out.println("\n");
        }
    }

    public static void enter() throws IOException {
        System.out.print("Press enter to continue.");
        in.readLine();
    }
}
