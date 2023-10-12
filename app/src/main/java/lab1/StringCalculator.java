package lab1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int Add(String input) {
        int sum = 0;
        ArrayList <Integer> negatives = new ArrayList<>();

        if (input.isEmpty()) {
            sum = 0;
        }
        else if (input.startsWith("//")) {
            int delimPosition = input.indexOf("\n");
            if (delimPosition != -1) {
                String customDelimiter = Pattern.quote(input.substring(2, delimPosition));
                String numbersToParse = input.substring(delimPosition + 1);
                String[] numsplit = numbersToParse.split(customDelimiter + "|,|\n");
                for (int i = 0; i < numsplit.length; i++) {
                    int number = Integer.parseInt(numsplit[i]);
                    if (number < 0) {
                    negatives.add(number);
                    }
                    else {
                        sum += number;
                    }
                }
            }
        }
        else if (input.contains(",") || input.contains("\n")) {
            String[] numsplit = input.split(",|\n");
            for (int i = 0; i < numsplit.length; i++) {
                int number = Integer.parseInt(numsplit[i]);
                sum += number;
                if (number < 0) {
                    negatives.add(number);
                }
            }
        }
        else if (!input.isEmpty()) {
            int number = Integer.parseInt(input);
            if (number >= 0) {
                sum += number;
            }
            else if (number < 0) {
                negatives.add(number);
            }
        }
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives are not allowed: " + negatives);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter input: ");
        String input = scanner.nextLine();
        input = input.replace("\\n", "\n");
        System.out.println("Result: " + Add(input));
        scanner.close();
    }    
}