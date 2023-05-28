package bubblesort;

import java.util.Arrays;

public class BubbleSort2 {
    public static void main(String[] args) {
        int[] arr = new int[]{10,5,33,60,2,30,90,60};


        bubbleSort2(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort2(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 1; j < arr.length - i; j++){
                if(arr[j] < arr[j - 1]){
                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
}
