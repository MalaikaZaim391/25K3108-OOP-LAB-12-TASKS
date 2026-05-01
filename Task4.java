package LAB12;
/*Prompt the user to enter a sentence and then performs a series of operations on the
sentence. The program should handle the following exceptions:
 If the input string is null or empty, the program should display an appropriate
error message.
 If the input string contains less than two words, the program should display an
appropriate error message.
Your program should use try-catch blocks to handle the exceptions. If the input and
operation are valid, display the modified sentence to the user.*/

public class Task4 {

    public void processSentence(String sentence) {
        try {
            if (sentence == null || sentence.trim().isEmpty()) {
                System.out.println("Error: The sentence is empty.");
                return;
            }
            //Split by whitespace to count words
            String[] words = sentence.trim().split("\\s+");

            if (words.length < 2) {
                throw new Exception("Error: Sentence must contain at least two words.");
            }
            System.out.println("Modified Sentence: " + sentence.toUpperCase());
            System.out.println("Word count: " + words.length);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void main(String[] args) {
        Task4 obj = new Task4();

        System.out.println();
        System.out.println("\tCORRECT SENTENCE MODIFIED");
        obj.processSentence("Hello There! How are you doing today kind Sir?");
        System.out.println();

        System.out.println("\tEMPTY SENTENCE");
        obj.processSentence("");
        System.out.println();

        System.out.println("\t<2 WORDS");
        obj.processSentence("hello");
        System.out.println();


    }


}
