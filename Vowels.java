import java.util.Scanner;
// Name: Sebastian Mielko
// Class: CSE 3305/SECTION#03
// Term: SPRING 2023
// Instructor: Prof. Majeed
// Assignment: 1
public class Vowels {
    public static int VowelCount = 0; //This variable is to track the amount of vowels

    public Vowels() {
    }

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String inputtedString = null;
        boolean isFinished = false;

        do {
            VowelCount = 0;
            System.out.print("\n---------MAIN MENU---------\n1. Read input string\n2. Compute number of vowels\n3. Exit program\nEnter Menu Selection: ");
            switch (myScanner.nextLine().toString()) {
                case "1":
                    System.out.print("Input String: ");
                    inputtedString = myScanner.nextLine().toString();
                    break;
                case "2":
                    if (inputtedString != null)
                    {
                        System.out.println("\nYou entered string: " + inputtedString);
                        System.out.print(CountVowels(inputtedString)); //calls recursive method
                    }
                    else { System.out.println("\nInvalid Input - Must enter a string (Menu choice 1)\n");} //error message
                    break;
                case "3":
                    System.out.print("\nGoodBye");
                    isFinished = true;
                    break;
                default:
                    System.out.println("\nInvalid Input\n");//default error message
            }
        } while(!isFinished);

    }


    public static String CountVowels(String inputtedString) {
        if (inputtedString.length() <= 1) //base case
            {
            CheckForVowels(inputtedString.substring(inputtedString.length() - 1)); //sends the last char of the string
            return "Number of Vowels: " + VowelCount + "\n";
            } else //recursive case
            {
            CheckForVowels(inputtedString.substring(inputtedString.length() - 1));
            return CountVowels(inputtedString.substring(0, inputtedString.length() - 1)); //recursive calla1
        }
    }

    public static void CheckForVowels(String inputtedString) {
        String regex = "[aeiouAEIOU]";
        if (inputtedString.matches(regex)) {
            ++VowelCount;
        } //I'm using this method as a helper method to increment the global variable if it is a vowel

    }
}
