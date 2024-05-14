package moden;

public class ComparisonDemo{
    public static void main(String[] args) {
        Student student1 = new Student("John", 95);
        Student student2 = new Student("Alice", 95);

        MarksComparator comparator = new MarksComparator();

        int comparisonResult = comparator.compare(student1, student2);

        if (comparisonResult > 0) {
            System.out.println("Higher");
        } else if (comparisonResult < 0) {
            System.out.println("Less");
        } else {
            System.out.println("Equal");
        }
    }
}


