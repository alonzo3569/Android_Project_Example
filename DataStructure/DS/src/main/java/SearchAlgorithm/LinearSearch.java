package SearchAlgorithm;

public class LinearSearch {

    public static int linearSearch(int[] a, int x){

        int ans = -1;

        for (int i = 0; i < a.length; i++){  // Time complexity : O(n)
            if (a[i] == x){
                ans = i;
                return i;
            }
        }

        return -1;
    }
}
