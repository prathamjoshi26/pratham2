package Collection;
import java.util.HashMap;
import java.util.Map;

    public class map {
        public static void main(String[] args) {
            // Initialize a map (HashMap)
            Map<String, String> myMap = new HashMap<>();

            // Add elements
            myMap.put("Employee", "id");
            myMap.put("Employee2", "Id");

            System.out.println(myMap);  // Output: {key1=value1, key2=value2}

            // Remove elements
            myMap.remove("Employee");

            System.out.println(myMap);  // Output: {key2=value2}

            // Clear all elements
            myMap.clear();

            System.out.println(myMap);  // Output: {}
        }
    }

