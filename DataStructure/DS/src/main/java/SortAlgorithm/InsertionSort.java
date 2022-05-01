package SortAlgorithm;

public class InsertionSort {

    public static int[] insertionSort(int a[]) {

        for (int i = 1; i < a.length; i++){  // Caution : starts from index "1"
            int element = a[i];
            int j = i-1;

            while (j >= 0 && element < a[j]){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = element;
        }

        return a;
    }
}
