package margeSort;

import java.util.Arrays;

public class MargeSortRecursive {
    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*1000);
        }
        margeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void margeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            margeSort(arr, left, mid);
            margeSort(arr, mid + 1, right);
            marge(arr, left, mid, right);
        }
    }

    public static void marge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }
        while (j <= right) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        for (k = 0; k < temp.length; k++) {
            arr[left + k] = temp[k];
        }
    }
}
