package Collection;


import java.util.*;

public class CollectionDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> list1 = new ArrayList<>();
        List<Person> list2 = new ArrayList<>();
        List<Person> list3 = new ArrayList<>();

        boolean running = true;
        while (running) {
            System.out.println("Choose an option:");
            System.out.println("1. Add to List 1");
            System.out.println("2. Add to List 2");
            System.out.println("3. Add to List 3");
            System.out.println("4. Display Lists");
            System.out.println("5. Exit");

            int choice = getIntInput(scanner, "Enter your choice: ");

            if (choice == 1) {
                add(scanner, list1);
            } else if (choice == 2) {
                add(scanner, list2);
            } else if (choice == 3) {
                add(scanner, list3);
            } else if (choice == 4) {
                displayLists(list1, list2, list3);
            } else if (choice == 5) {
                running = false;
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }

        scanner.close();
    }

    public static int getIntInput(Scanner scanner, String prompt) {
        int input = -1;
        boolean valid = false;
        while (!valid) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                valid = true;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
            }
            scanner.nextLine(); // consume the invalid input or newline character
        }
        return input;
    }

    public static void add(Scanner scanner, List<Person> list) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        int id = getIntInput(scanner, "Enter ID: ");
        System.out.print("Enter position: ");
        String position = scanner.nextLine();

        list.add(new Person(name, id, position));
        System.out.println("Added to list: " + name + " (ID: " + id + ", Position: " + position + ")");
    }

    public static void displayLists(List<Person> list1, List<Person> list2, List<Person> list3) {
        System.out.println("List 1 elements:");
        for (Person person : list1) {
            System.out.println(person);
        }

        System.out.println("List 2 elements:");
        for (Person person : list2) {
            System.out.println(person);
        }

        System.out.println("List 3 elements:");
        for (Person person : list3) {
            System.out.println(person);
        }
    }
}