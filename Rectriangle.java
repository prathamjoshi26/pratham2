public class Rectriangle {
        public static int calculateArea(int length, int width) {
            return length * width;
        }

        public static void main(String[] args) {
            int length = 5;
            int width = 5;
            int area = calculateArea(length, width);
            System.out.println("Area of the rectangle: " + area);
        }
    }

