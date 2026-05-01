package LAB12;
/*Ask the user to enter two numbers and perform a mathematical operation on them. The
program should handle the following exceptions:
 If the input for either number is null or empty, the program should display an
appropriate error message.
 If the input for either number does not represent a valid integer or double (i.e., it
contains non-numeric characters), the program should display an appropriate error
message.
 If the user attempts to divide by zero, the program should display an appropriate
error message.
Your program should use try-catch blocks to handle the exceptions. If the input is valid,
the program should perform the mathematical operation and display the result to the user.*/

import java.util.Scanner;

public class Task3 {

    public void performOperation() {
        Scanner sc = new Scanner(System.in);

        try {
            //first number
            System.out.print("Enter first number: ");
            String input1 = sc.nextLine();
            //second number
            System.out.print("Enter second number: ");
            String input2 = sc.nextLine();

            //Check for null or empty inputs
            if (input1.trim().isEmpty() || input2.trim().isEmpty()) {
                System.out.println("Error: Numbers cannot be null or empty.");
                return;
            }

            //Convert inputs to doubles (handles both integers and decimals)
            double num1 = Double.parseDouble(input1);
            double num2 = Double.parseDouble(input2);

            //Ask for the operation
            System.out.print("Choose an operation (+, -, *, /): ");
            String op = sc.nextLine();

            if (op.trim().isEmpty()) {
                System.out.println("Error: Operation cannot be empty.");
                return;
            }

            double result = 0;
            //Perform calculation based on operation
            switch (op) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    // Handle division by zero
                    if (num2 == 0) {
                        throw new ArithmeticException("Division by zero is not allowed.");
                    }
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("Error: Invalid operation selected.");
                    return;
            }
            System.out.println("The result of " + num1 + " " + op + " " + num2 + " is: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid numeric value.");
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        Task3 obj = new Task3();
        obj.performOperation();
    }



}

