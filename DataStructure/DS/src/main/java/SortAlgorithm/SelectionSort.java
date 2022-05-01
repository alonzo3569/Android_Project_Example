package SortAlgorithm;

import java.util.Arrays;

public class SelectionSort {

    public static int[] selectionSort(int a[]){

        for (int i = 0; i < a.length; i++){

            int minIndex = i;

            for(int j = i+1; j < a.length; j++){

                if (a[minIndex] > a[j]) minIndex = j;
            }

            // swap min value to first position
            int holder = a[i];
            a[i] = a[minIndex];
            a[minIndex] = holder;
        }

        return a;
    }

}
