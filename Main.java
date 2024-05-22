import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the height of the triangle: ");
        int height = scanner.nextInt();

        for (int i = 1; i <= height; i++) {
            String row = "";
            for (int j = 0; j < i; j++) {
                row += "*";
            }
            System.out.println(row);
        }
    }
}