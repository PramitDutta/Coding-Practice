import java.util.Scanner;

public class MaxMin {

public static void main(String args[])
{
    Scanner a = new Scanner (System.in);
    System.out.println("Enter inputs (This program calculates the largest and smallest input). Press Q to stop :");
    
    String input=a.next();

    int largest = Integer.parseInt(input);
    int smallest = largest;
    while (a.next()!="Q" && a.hasNextInt()) {
        int in = a.nextInt();
        largest = Math.max(largest, in);
        smallest = Math.min(smallest, in);
    }

    System.out.println("Largest: " + largest);
    System.out.println("Smallest: " + smallest);
    }
}

