package Days;

import java.util.*;

public class DaysInMonth {
    
    private static final Map<String, Integer> monthMap = new HashMap<>();
    
    static {
        monthMap.put("january", 1);
        monthMap.put("jan", 1);
        monthMap.put("jan.", 1);
        
        monthMap.put("february", 2);
        monthMap.put("feb", 2);
        monthMap.put("feb.", 2);
        
        monthMap.put("march", 3);
        monthMap.put("mar", 3);
        monthMap.put("mar.", 3);
        
        monthMap.put("april", 4);
        monthMap.put("apr", 4);
        monthMap.put("apr.", 4);
        
        monthMap.put("may", 5);
        
        monthMap.put("june", 6);
        monthMap.put("jun", 6);
        monthMap.put("jun.", 6);
        
        monthMap.put("july", 7);
        monthMap.put("jul", 7);
        monthMap.put("jul.", 7);
        
        monthMap.put("august", 8);
        monthMap.put("aug", 8);
        monthMap.put("aug.", 8);
        
        monthMap.put("september", 9);
        monthMap.put("sep", 9);
        monthMap.put("sep.", 9);
        monthMap.put("sept", 9);
        monthMap.put("sept.", 9);
        
        monthMap.put("october", 10);
        monthMap.put("oct", 10);
        monthMap.put("oct.", 10);
        
        monthMap.put("november", 11);
        monthMap.put("nov", 11);
        monthMap.put("nov.", 11);
        
        monthMap.put("december", 12);
        monthMap.put("dec", 12);
        monthMap.put("dec.", 12);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int month = -1, year = -1;
        
        // Ask until valid month
        while (month == -1) {
            System.out.print("Enter month: ");
            String input = scanner.nextLine().trim().toLowerCase();
            
            // Try numeric month
            try {
                int num = Integer.parseInt(input);
                if (num >= 1 && num <= 12) {
                    month = num;
                } else {
                    System.out.println("Invalid month number.");
                }
            } catch (NumberFormatException e) {
                // Try string month
                if (monthMap.containsKey(input)) {
                    month = monthMap.get(input);
                } else {
                    System.out.println("Invalid month name.");
                }
            }
        }
        
        // Ask until valid year
        while (year == -1) {
            System.out.print("Enter year: ");
            String input = scanner.nextLine().trim();
            if (input.matches("\\d+")) {  // only digits
                year = Integer.parseInt(input);
            } else {
                System.out.println("Invalid year.");
            }
        }
        
        int days = getDaysInMonth(month, year);
        System.out.println(days + " days");
        
        scanner.close();
    }
    
    public static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1: return 31;
            case 2: return isLeapYear(year) ? 29 : 28;
            case 3: return 31;
            case 4: return 30;
            case 5: return 31;
            case 6: return 30;
            case 7: return 31;
            case 8: return 31;
            case 9: return 30;
            case 10: return 31;
            case 11: return 30;
            case 12: return 31;
            default: return -1;
        }
    }
    
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        return year % 4 == 0;
    }
}