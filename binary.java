package binery;

import java.util.Scanner;

public class binary {
    public static void main(String [] arg){


        long a = 1, bin = 0, rem;

        System.out.println("Enter a number:");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();  // Read the input number

        // Initialize originalNum with num's value
        int originalNum = num;

        while (num > 0) {
            rem = num % 2;
            bin = bin + rem * a;
            num /= 2;
            a *= 10;
        }

        System.out.println("Binary representation of " + originalNum + " is " + bin);
    }
}