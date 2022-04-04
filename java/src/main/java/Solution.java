// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
import java.util.ArrayList;
import java.util.List;
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static List<Integer> cellCompete(int[] states, int days)
    {
        int[] currentStates = new int[10];
        int[] futureStates = new int[10];
        List<Integer> result = new ArrayList<Integer>();
        currentStates[0] = 0;
        currentStates[9] = 0;
        for (int x=1; x <= 8; x++) {
            currentStates[x] = states[x-1];
            futureStates[x] = states[x-1];
        }
        for (int i=1; i<= days;i++) {
            for (int z=1; z <= states.length; z++) {
                if (currentStates[z-1] == currentStates[z+1]) {
                    futureStates[z] = 0;
                } else {
                    futureStates[z] = 1;
                }
            }
            for (int w = 1; w <= states.length ; w++) {
                currentStates[w] = futureStates[w];
            }
        }
        for (int j = 1; j <= states.length; j++) {
            result.add(currentStates[j]);
        }
        return result;
    }

    public static int twoGcd(int one, int two) {
        int greater;
        int lower;
        if (one > two) {
            greater = one;
            lower = two;
        } else {
            greater = two;
            lower = one;
        }
        int remainder = greater % lower;
        if (remainder == 0) {
            return lower;
        }
        return twoGcd(lower,remainder);
    }

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static int generalizedGCD(int num, int[] arr)
    {
        int currentValue = arr[0];
        for (int i=0;i<num-1;i++) {
            currentValue = twoGcd(currentValue, arr[i+1]);
            if (currentValue == 1) {
                return 1;
            }
        }
        return currentValue;
    }


}
