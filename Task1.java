package LAB12;
/*You are building a program that calculates the average of a list of integers. Write a Java
program that handles the following exceptions:
 If the list is null or empty, the program should display an appropriate error
message.
 If any of the integers in the list are not valid integers (i.e., they contain non-numeric characters),
the program should skip that integer and display only
numeric data’s average.
 If the list contains only invalid integers (non – numeric), the program should
display an appropriate message.
Your program should use try-catch blocks to handle the exceptions. You can assume that
the list is provided as an argument.*/


public class Task1 {

    public void calculateAverage(String[] list) {
        try {
            if (list == null || list.length == 0) {
                System.out.println("Error: The list is null or empty.");
                return;
            }
            double sum = 0;
            int count = 0;
            for (String item : list) {
                try {
                    int num = Integer.parseInt(item);
                    sum += num;
                    count++;
                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid input: " + item);
                    //System.out.println(e.getMessage());
                }
            }
            if (count == 0) {
                System.out.println("Error: The list contains no valid numeric data.");
            } else {
                System.out.println("The average is: " + (sum / count));
            }
        } catch (Exception e) {
            System.out.println("An unexpected error occurred.");
            //System.out.println(e.getMessage());
        }
    }



    public static void main(String[] args) {

        Task1 test = new Task1();

        //skipping invalid
        System.out.println("\tSKIPPING INVALID");
        String[] list = {"malaika", "20", "7", "8", "zaim", "4"};
        test.calculateAverage(list);
        System.out.println();

        //empty
        System.out.println("\tEMPTY");
        String[] list2 = {};
        test.calculateAverage(list2);
        System.out.println();

        //all string data
        System.out.println("\tNO NUMERIC DATA");
        String[] list3 = {"ho", "he", "yay", "yo"};
        test.calculateAverage(list3);
        System.out.println();

    }



}


