package selectionort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,7,3,5,844,34,77,33,44,55,11,3324};

        selectionSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++){
            int index = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[index]){
                    index = j;
                }
            }
            int smallestNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallestNumber;
        }
    }

}
