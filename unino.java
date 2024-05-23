package binery;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class unino {
        public static void main(String[] args) {
            int[] arr1 = {9, 3, 4, 5, 8};
            int[] arr2 = { 3, 6};

            findUnionAndIntersection(arr1, arr2);

            int[] arr3 = {2, 5, 6,8};
            int[] arr4 = {4, 6, 8, 10};

            findUnionAndIntersection(arr3, arr4);
        }

        public static void findUnionAndIntersection(int[] arr1, int[] arr2) {
            Arrays.sort(arr1);
            Arrays.sort(arr2);

            Set<Integer> unionSet = new HashSet<>();
            Set<Integer> intersectionSet = new HashSet<>();

            int i = 0, j = 0;
            while (i < arr1.length && j < arr2.length) {
                if (arr1[i] < arr2[j]) {
                    unionSet.add(arr1[i]);
                    i++;
                } else if (arr2[j] < arr1[i]) {
                    unionSet.add(arr2[j]);
                    j++;
                } else {
                    unionSet.add(arr1[i]);
                    intersectionSet.add(arr1[i]);
                    i++;
                    j++;
                }
            }

            while (i < arr1.length) {
                unionSet.add(arr1[i]);
                i++;
            }

            while (j < arr2.length) {
                unionSet.add(arr2[j]);
                j++;
            }

            System.out.println("Union: " + unionSet);
            System.out.println("Intersection: " + intersectionSet);
        }
    }


