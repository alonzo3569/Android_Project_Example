package SortAlgorithm;

import static SortAlgorithm.InsertionSort.insertionSort;
import static SortAlgorithm.SelectionSort.selectionSort;

import java.util.Arrays;

public class SortApp {
    public static void main(String[] args) {

//        int[] array = selectionSort(new int[] {19,15,17,16,13});
        int[] array = insertionSort(new int[] {19,15,17,16,13});
        System.out.println(Arrays.toString(array));
    }
}
