package SearchAlgorithm;

public class Recursion {
    public static void reduceByOne(int n){

        if (n >= 0){  // Base case : condition for recursion to stop
            reduceByOne(n - 1);
        }

        System.out.println("Complete call: " + n); // executed after recursive function
    }
}
