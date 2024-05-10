import java.util.Scanner;

public class triangle {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the height of the triangle: ");
            int height = scanner.nextInt();

            for (int i = 1; i <= height; i++) {
                String spaces = "";
                for (int j = 0; j < height - i; j++) {
                    spaces += " ";
                }
                String stars = "";
                for (int j = 0; j < i; j++) {
                    stars += "*";
                }
                System.out.println(spaces + stars);
            }
        }
    }

