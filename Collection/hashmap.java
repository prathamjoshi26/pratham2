package Collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

    public class hashmap {
        public static void main(String[] args) {
            
            Map<Integer, String> myMap = new HashMap<>();


            myMap.put(1, "Item 1");
            myMap.put(2, "Item 2");
            myMap.put(3, "Item 3");
            myMap.put(4, "Item 4");


            Scanner scanner = new Scanner(System.in);


            System.out.println("The items in the map are:");
            for (Map.Entry<Integer, String> entry : myMap.entrySet()) {
                System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            }

            System.out.println("Enter a key to get the value:");
            int key = scanner.nextInt();

            if (myMap.containsKey(key)) {
                System.out.println("The value for key " + key + " is: " + myMap.get(key));
            } else {
                System.out.println("Key not found in the map.");
            }

            scanner.close();
        }
    }


