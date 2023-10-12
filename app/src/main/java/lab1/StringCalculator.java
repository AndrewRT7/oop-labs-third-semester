package lab1;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class StringCalculator {
    public static int Add(String input) {
        int sum = 0;
        ArrayList <Integer> negatives = new ArrayList<>();
        ArrayList <String> customDelimiters = new ArrayList<>();

        if (input.isEmpty()) {
            sum = 0;
        }
        else if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("\\[([^\\]]+)\\]").matcher(input);
            while (matcher.find()) {
                customDelimiters.add(Pattern.quote(matcher.group(1)));
            }
            if (customDelimiters.isEmpty()) {
                customDelimiters.add(Pattern.quote(input.substring(2, 3)));
            }
            customDelimiters.sort((a, b) -> Integer.compare(b.length(), a.length()));
            String customDelimitersPattern = String.join("|", customDelimiters);
            String inputToParse = input.substring(input.indexOf("\n") + 1);
            String[] numsplit = inputToParse.split(customDelimitersPattern + "|,|\n");
            for (String numbers : numsplit) {
                int number = Integer.parseInt(numbers);
                if (number >= 0 && number < 1001) {
                    sum += number;
                } 
                else if (number < 0) {
                    negatives.add(number);
                }
            }
        }
        else if (input.contains(",") || input.contains("\n")) {
            String[] numsplit = input.split(",|\n");
            for (int i = 0; i < numsplit.length; i++) {
                int number = Integer.parseInt(numsplit[i]);
                if (number >= 0 && number < 1001) {
                    sum += number;
                }
                else if (number < 0) {
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