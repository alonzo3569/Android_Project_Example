package SearchAlgorithm;

public class Recursion {

    public static void reduceByOne(int n){

        if (n >= 0){  // Base case : condition for recursion to stop
            reduceByOne(n - 1);
        }

        System.out.println("Complete call: " + n); // executed after recursive function
    }

    public static int recursiveLinearSearch(int[] A, int i, int x) {

        if (i > A.length - 1) return -1;  // x was not found in array
        else if (A[i] == x) return i;     // found x
        else return recursiveLinearSearch(A, i + 1, x); // index+1 & search again

    }

    public static int recursiveBinarySearch(int[] A, int p, int r, int x){

        System.out.println("[ "+ p + "..." + r + " ]");

        if (p > r) return -1;
        else {
            int q = (p + r)/2;

            if (A[q] == x) return q;
            else if (A[q] > x) return recursiveBinarySearch(A, p, q-1 , x);
            else return recursiveBinarySearch(A, q+1, r , x);
        }
    }
}
