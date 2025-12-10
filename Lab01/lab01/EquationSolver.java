package lab01;
import java.util.Scanner;

public class EquationSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. First-degree equation (one variable)");
        System.out.println("2. System of first-degree equations (two variables)");
        System.out.println("3. Second-degree equation (one variable)");
        System.out.print("Choose an option: ");
        
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                solveFirstDegreeOne(scanner);
                break;
            case 2:
                solveSystemLinear(scanner);
                break;
            case 3:
                solveSecondDegree(scanner);
                break;
        }
        
        scanner.close();
    }

    public static void solveFirstDegreeOne(Scanner scanner) {
        
        System.out.print("Enter a: ");
        double a = scanner.nextDouble();
        
        System.out.print("Enter b: ");
        double b = scanner.nextDouble();
        
        if (a == 0) {
            if (b == 0) {
                System.out.println("The equation has infinitely many solutions.");
            } else {
                System.out.println("The equation has no solution.");
            }
        } else {
            double x = -b / a;
            System.out.printf("Solution: x = " + x);
        }
    }
    
    public static void solveSystemLinear(Scanner scanner) {

        System.out.print("Enter a11: ");
        double a11 = scanner.nextDouble();
        System.out.print("Enter a12: ");
        double a12 = scanner.nextDouble();
        System.out.print("Enter b1: ");
        double b1 = scanner.nextDouble();
        
        System.out.print("Enter a21: ");
        double a21 = scanner.nextDouble();
        System.out.print("Enter a22: ");
        double a22 = scanner.nextDouble();
        System.out.print("Enter b2: ");
        double b2 = scanner.nextDouble();


        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;
        
        System.out.printf("\nD = " + D);
        System.out.printf("\nD1 = " + D1);
        System.out.printf("\nD2 = " + D2);
        System.out.println();
        
        if (D != 0) {
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.println("\nThe system has a unique solution:");
            System.out.printf("x1 = " + x1);
            System.out.printf("\nx2 = " + x2);

        } else {
            if (D1 == 0 && D2 == 0) {
                System.out.println("The system has infinitely many solutions.");
            } else {
                System.out.println("The system has no solution.");
            }
        }
    }

    public static void solveSecondDegree(Scanner scanner) {
        
        System.out.print("Enter a: ");
        double a = scanner.nextDouble();
        
        System.out.print("Enter b: ");
        double b = scanner.nextDouble();
        
        System.out.print("Enter c: ");
        double c = scanner.nextDouble();

        
        if (a == 0) {
            System.out.println("This is a first-degree equation.");
            if (b == 0) {
                if (c == 0) {
                    System.out.println("The equation has infinitely many solutions.");
                } else {
                    System.out.println("The equation has no solution.");
                }
            } else {
                double x = -c / b;
                System.out.printf("Solution: x = " + x);
            }
        } else {
            double delta = b * b - 4 * a * c;
            System.out.printf("Delta = " + delta);
            
            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("\nThe equation has two distinct real roots:");
                System.out.printf("x1 = " + x1);
                System.out.printf("\nx2 = " + x2);
            } else if (delta == 0) {
                double x = -b / (2 * a);
                System.out.println("\nThe equation has a double root:");
                System.out.printf("x = " + x);
            } else {
                System.out.println("\nThe equation has no real roots.");

                double realPart = -b / (2 * a);
                double imaginaryPart = Math.sqrt(-delta) / (2 * a);
                System.out.println("\nComplex roots:");
                System.out.printf("x1 = " + realPart + " + " + imaginaryPart + "i");
                System.out.printf("\nx2 = " + realPart + " - " + imaginaryPart + "i");
            }
        }
    }
}