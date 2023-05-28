package binarysearch;

import java.util.Arrays;

public class BinarySearchIterative {
    //Iterative
    public static void binarySearchIterative(int[] arr, int first, int last, int key) {
        int mid = (first + last) / 2;
        while (first <= last) {
            if (arr[mid] < key) {
                first = mid + 1;
            } else if (arr[mid] == key) {
                System.out.println("Element is found at index " + mid);
                break;
            } else {
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }
        if (first > last) {
            System.out.println("Element not found ");
        }
    }


    public static void main(String[] args) {
        int[] arr = {12, 34, 56, 77, 3, 5, 75, 23, 99};
        Arrays.sort(arr);
        int first = 0;
        int last = arr.length - 1;
        int key = 77;
        binarySearchIterative(arr,first,last,key);

    }
}
