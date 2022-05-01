package SearchAlgorithm;

import static SearchAlgorithm.BinarySearch.binarySearch;
import static SearchAlgorithm.Recursion.recursiveBinarySearch;
import static SearchAlgorithm.Recursion.recursiveLinearSearch;

public class SearchApp {

    public static void main(String[] args) {

//        System.out.println(binarySearch(new int[] {1, 2, 3, 4, 5}, 1));
//        linearSearch(new int[] {1, 2, 3, 4, 5}, 1);
//        System.out.println(recursiveLinearSearch(new int[] {1, 2, 3, 4, 5}, 0, 5));
        System.out.println(recursiveBinarySearch(new int[] {1, 2, 3, 4, 7, 9, 12, 18},
                0, 7, 18));
    }

}
