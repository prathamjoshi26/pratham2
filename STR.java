public class STR {

        public static void main(String[] args) {
            int startYear = 2000;
            int numberOfStrings = 7; // You can change this to print more strings if needed

            for (int i = 0; i < numberOfStrings; i++) {
                String currentString = "$" + (startYear + i);
                System.out.println(currentString);
            }
        }
    }

