package LAB12;
/*Calculate the factorial of a given integer n. The program should take input from the user
in the form of a string and convert it to an integer (Integer.parseInt()). Write a Java
program that handles the following exceptions:
 If the input string is null or empty, the program should display an appropriate
error message.
 If the input string does not represent a valid integer (i.e., it contains non-numeric
characters), the program should display an appropriate error message.
 If the input integer is negative, the program should display an appropriate error
message.
 If the input integer is too large to calculate the factorial (i.e., it causes an integer
overflow), the program should display an appropriate error message.
Your program should use try-catch blocks to handle the exceptions. If the input integer is
valid and can be used to calculate the factorial, the program should calculate the factorial
and display it to the user.*/


public class Task2 {

    public void findFactorial(String input) {
        try {
            if (input == null || input.isEmpty()) {
                System.out.println("Error: Input cannot be empty.");
                return;
            }
            int n = Integer.parseInt(input);
            if (n < 0) {
                System.out.println("Error: Cannot calculate factorial of a negative number.");
                return;
            }
            long fact = 1;
            for (int i = 1; i <= n; i++) {
                long temp = fact * i;
                // Check for overflow
                if (temp < fact) {
                    System.out.println("Error: Integer overflow! Number is too large.");
                    return;
                }
                fact = temp;
            }
            System.out.println("Factorial of " + n + " is: " + fact);
        } catch (NumberFormatException e) {
            System.out.println("Error: Please enter a valid whole number.");
        }
    }

    public static void main(String[] args) {
        Task2 test = new Task2();

        //null
        System.out.println("\tEMPTY");
        String input = "";
        test.findFactorial(input);
        System.out.println();


        //negative
        System.out.println("\tNEGATIVE NUM");
        input = "-7";
        test.findFactorial(input);
        System.out.println();

        //normal
        System.out.println("\tFACTORIAL OF SMALL POSITIVE NUMBER");
        input = "7";
        test.findFactorial(input);
        System.out.println();

        //overflow
        System.out.println("\tOVERFLOW");
        input = "231";
        test.findFactorial(input);

    }



}
