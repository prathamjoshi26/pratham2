public class ValleyElement {

        public static void main(String[] args) {
            int[] array = {5,3,3, 6, 7, 4, 2,1};

            int valleyIndex = findValley(array);

            if (valleyIndex != -1) {
                System.out.println("The opposite element of the peak is: " + array[valleyIndex]);
            } else {
                System.out.println("No opposite element found.");
            }
        }

        public static int findValley(int[] array) {
            int n = array.length;
            int valleyIndex = -1;

            for (int i = 1; i < n - 1; i++) {
                if (array[i] <= array[i - 1] && array[i] <= array[i + 1]) {
                    valleyIndex = i;
                    break;
                }
            }

            return valleyIndex;
        }
    }

