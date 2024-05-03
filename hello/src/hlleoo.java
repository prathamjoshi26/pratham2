
import java.util.*;
class Demo {

    static void largest2(Integer arr[], int arr_size)
    {

        Arrays.sort(arr, Collections.reverseOrder());

        for (int i = 1; i < arr_size; i++) {


            if (arr[i] != arr[0]) {
                System.out.printf("The second largest "
                                + "element is %d\n",
                        arr[i]);
                return;
            }
        }

        System.out.printf("There is no second "
                + "largest element\n");
    }

    public static void main(String[] args)
    {
        Integer arr[] = {5,5,5,4,};
        int n = arr.length;
        largest2(arr, n);
    }
}
