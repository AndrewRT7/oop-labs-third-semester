package lab1;

import java.util.Scanner;

public class StringCalculator {
    public static int Add(String input) {
        int sum = 0;

        if (input.isEmpty()) {
            sum = 0;
        }
        else if (input.contains(",") || input.contains("\n")) {
            String[] numsplit = input.split(",|\n");
            for (int i = 0; i < numsplit.length; i++) {
                int number = Integer.parseInt(numsplit[i]);
                sum += number;
            }
        }
        else if (!input.isEmpty()) {
            int number = Integer.parseInt(input);
            if (number >= 0) {
                sum += number;
            }
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