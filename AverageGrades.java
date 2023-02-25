import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
// Name: Sebastian Mielko
// Class: CSE 3305/SECTION#03
// Term: SPRING 2023
// Instructor: Prof. Majeed
// Assignment: 1
public class AverageGrades {
    public static void main(String[] args) {
        String selection = null;

        Scanner myScanner = new Scanner(System.in);
        //UPDATE TO ASSIGNMENT - INITIAL SETUP:
        double[] classGrades = new double [SetClassSize(myScanner)]; //THIS IS TO GET INITIAL CLASS SIZE
        GetClassGrades(myScanner,classGrades);

        do {
            DisplayMenu();
            selection = myScanner.next().toString();
            switch (selection)
            {
                case "1":
                    SetClassSize(myScanner);
                    classGrades = new double[classGrades.length];
                    break;
                case "2":
                    if (classGrades.length > 0)
                        GetClassGrades(myScanner,classGrades);
                    else
                    {
                        System.out.print("Class has no size.");
                    }
                    break;
                case "3":
                    System.out.println("You entered class size: " + classGrades.length);
                    System.out.println("You entered grades: " + Arrays.toString(classGrades));
                    System.out.println("Class Average: "
                            + Math.floor(RecursiveAverage(classGrades, classGrades.length)*100) / 100);
                    break;
            }
        } while (!selection.equals("4"));
    }

public static double RecursiveAverage(double [] classGrades, int arrayLength)
{
    if (arrayLength == 1)  //base case check for the last element in the array
    {
        return classGrades[0];//collapsing the stack
    }
    return ((classGrades[arrayLength-1]//recursive call using the next element
            + RecursiveAverage(classGrades,arrayLength-1)
            * (arrayLength-1))
            / arrayLength);
//This formula will recursively calculate the average
}
    public static void GetClassGrades(Scanner myScanner, double [] classGrades) //for-loop to set class grades
    {
        for (int i = 0; i < classGrades.length; i++)
        {
            System.out.print("Enter Grade ("+  (i+1)  +"): ");
            classGrades[i] = myScanner.nextDouble();
        }
    }

    public static int SetClassSize(Scanner myScanner) //takes a >0 integer and will assign it to the class array size
    {
        int classSize = 0;
        do
        {
            System.out.print("\nEnter class size: ");
            try {
                classSize = myScanner.nextInt();
                if (classSize <= 0)
                    System.out.println("Class size cannot be empty or negative");
            } catch (Exception e) {
                System.out.print("The class size must be a valid integer");
            }//check for negative class sizes
        } while (classSize <= 0);
        return classSize;
    }
    public static void DisplayMenu() //Displays Menu on call
    {
        System.out.print("\n--------MAIN MENU-------\n" +
                "1. Read class size\n" +
                "2. Read class grades\n" +
                "3. Compute class average\n" +
                "4. Exit program\n" +
                "Enter option number:");
    }
}