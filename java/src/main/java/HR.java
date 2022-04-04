import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HR {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long maxSum = 0, currentSum = 0;
        int[] myArray = new int[n];
        for (int i = 0; i < n; i++) {
            myArray[i] = 0;
        }
        for (int row = 0; row < queries.length; row++) {
            myArray[queries[row][0]-1] += queries[row][2];
            if (queries[row][1] < n) {
                myArray[queries[row][1]] -= queries[row][2];
            }
        }
        for (int i=0;i<n;i++) {
            currentSum += myArray[i];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        return maxSum;
    }

    private static final Scanner scanner = new Scanner(System.in);


}

