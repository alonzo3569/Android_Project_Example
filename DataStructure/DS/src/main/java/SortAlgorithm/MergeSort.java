package SortAlgorithm;

import java.util.Arrays;

public class MergeSort {

    public static void sort(int inputArray[]){
        sort(inputArray, 0, inputArray.length-1);
    }

    public static void sort(int inputArray[], int start, int end){
        if(end <= start){
            return; // we're done traversing the array
        }

        int mid = (start + end)/2;
        sort(inputArray, start, mid); // sort left half
        sort(inputArray, mid+1, end); // sort right half
        merge(inputArray, start, mid, end); // merge sorted results into the inputArray
    }

    public static void merge(int A[], int start, int mid, int end) {

        // init l, r array (+1 for largest value)
        int mergeArraySize = end - start +1;
        int lArraySize = (mid - start + 1) + 1;
        int rArraySize = (end - (mid+1) +1) + 1;
        int[] lArray = new int[lArraySize];
        int[] rArray = new int[rArraySize];

        // write array to L, R
        for (int i = 0; i < lArraySize - 1; i++){
            lArray[i] = A[start + i];
        }

        for (int i = 0; i < rArraySize - 1; i++){
            rArray[i] = A[(mid+1) + i];
        }

        // Add largest value to the end of l, r
        lArray[lArraySize - 1] = Integer.MAX_VALUE;
        rArray[rArraySize - 1] = Integer.MAX_VALUE;

        // merge
        int lPointer = 0;
        int rPointer = 0;

        for(int k = 0; k < mergeArraySize; k++){ // array A pointer "k"

            // move smaller value to array A, & move pointer in l, r
            if (lArray[lPointer] < rArray[rPointer]){
                A[start + k] = lArray[lPointer];
                lPointer++;
            } else { // r smaller or equal
                A[start + k] = rArray[rPointer];
                rPointer++;
            }
        }

        // Debugging purpose
        //System.out.println("Merge(" + start + "," + mid + "," + end + ")");
        //System.out.println(Arrays.toString(lArray));
        //System.out.println(Arrays.toString(rArray));
        //System.out.println(Arrays.toString(A));
    }

    public static void main(String[] args) {

        // Test case 1 :
        merge(new int[] {1,5,7,8,2,4,6,9}, 0, 3, 7);

        // Test case 2 :
        merge(new int[] {1,2,3,4,5,6,7} , 0, 3, 6); //{1,5,7,8,10,2,4,6,9}

        // Test case 3 :
        int[] a = new int[] {12,7,5,0,9,2}; //{1,5,7,8,10,2,4,6,9}
        sort(a);
        System.out.println(Arrays.toString(a));
    }

}
