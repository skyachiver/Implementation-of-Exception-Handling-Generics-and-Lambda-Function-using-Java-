import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.BiFunction;

// this class will perform arithmatic operations - addition, multiplication, division, and subtraction where the The T represents the generic type which can be any numeric type and amkes it flexible for handlin different formats
class calc<T extends Number> {
    
    public T compute(BiFunction<T, T, T> operation, T a, T b) {   // takes a lambda function as the operation parameter and two numbers of generic type T ( a and b).
        return operation.apply(a, b);
    }
}

public class Assignment_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //creates a generic calc for doubles
        calc<Double> calc = new calc<>();
        //used try-catch blocks to handle runtime errors
        try {
            //inputs two numbers
            System.out.print("Enter the first number: ");
            double num1 = scanner.nextDouble();
            
            System.out.print("Enter the second number: ");
            double num2 = scanner.nextDouble();
            //used lambda expression to simplify the code by avoiding the need for separate method definitions for each operation.
            //lambda expressions for arithmetic operations
            BiFunction<Double, Double, Double> add = (a, b) -> a + b;
            BiFunction<Double, Double, Double> subtract = (a, b) -> a - b;
            BiFunction<Double, Double, Double> multiply = (a, b) -> a * b;
            BiFunction<Double, Double, Double> divide = (a, b) -> {
                if (b == 0) {
                    throw new ArithmeticException("Cannot divide by zero!");
                }
                return a / b;
            };

            //arithmetic operations
            System.out.println("Addition: " + calc.compute(add, num1, num2));
            System.out.println("Subtraction: " + calc.compute(subtract, num1, num2));
            System.out.println("Multiplication: " + calc.compute(multiply, num1, num2));
            System.out.println("Division: " + calc.compute(divide, num1, num2));
            
        } catch (ArithmeticException e) {
            //handling divide by zero error
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            //handling invalid input errors (non-numeric values)
            System.out.println("Error: Invalid input! Please enter numeric values.");
        } catch (Exception e) {
            //handling other unforeseen errors
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
