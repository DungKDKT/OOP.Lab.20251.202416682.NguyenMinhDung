package lab01;
import java.util.Arrays;
import java.util.Scanner;

public class ArraySortSumAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] myArray = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + i + ": ");
            myArray[i] = scanner.nextInt();
        }

        System.out.println("\nOriginal Array:");
        System.out.println(Arrays.toString(myArray));

        Arrays.sort(myArray);

        System.out.println("\nSorted Array:");
        System.out.println(Arrays.toString(myArray));
        
        // Calculate sum
        int sum = 0;
        for (int i = 0; i < myArray.length; i++) {
            sum += myArray[i];
        }
        
        // Calculate average
        double average = (double) sum / myArray.length;
        
        System.out.println("Elements' sum: " + sum);
        System.out.println("Elements' average: " + average);
        
        scanner.close();
    }
}