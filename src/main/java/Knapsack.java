import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Knapsack {
    public static void main(String[] args) {
        int[] a = {1, 4, 5, 3, 2, 1};
        int[] b = {2, 5, 7, 4, 2, 2};
        // int[] c = {6,0,6,8};
        int[] c = {99,1,1,1,1,1,1};

        // int minCars = Main.minCars(a, b);
        // int filters = Main.pollutionFilters(c);
        int[] v = { 30, 14, 16, 9 };
        int[] w = { 6, 3, 4, 2 };
        int W = 7;
        int[][] mochilaMemo = knapsackMemo(v,w,W);
        List<Integer> items = knapsackItems(mochilaMemo, w, W, v.length, new ArrayList<>());
        System.out.println(items);
    }

    public static int minCars(int[] a, int[] b) {
        int people = 0;
        int cars = 0;
        for (int i = 0; i < a.length; i++) {
            people += a[i];
        }
        Arrays.sort(b);
        for (int j = b.length - 1; j >= 0; j--) {
            if (people > 0) {
                people = people - b[j];
                cars += 1;
            }
        }
        return cars;
    }


    public static int pollutionFilters(int[] a) {
        Arrays.sort(a);
        int totalPollution = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            totalPollution += a[i];
        }
        float goal = (float) totalPollution / 2;
        System.out.println(goal);
        int filters = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            float curPollution = a[i];
            if (i == 0) {
                while (goal > 0) {
                    curPollution = curPollution / 2;
                    filters += 1;
                    goal -= curPollution;
                }
            } else {
                int nextFactoryPollution = a[i-1];
                while (goal > 0 && curPollution >= nextFactoryPollution) {
                    curPollution = curPollution / 2;
                    filters += 1;
                    goal -= curPollution;
                }
            }
        }
        return filters;
    }

    public static int[][] knapsackMemo(int[] value, int[] weight, int W) {
        int[][] memo = new int[W+1][value.length+1];
        for (int i = 0; i <= value.length ; i++) {
            memo[0][i] = 0;
        }
        for (int i = 0; i <= W; i++) {
            memo[i][0] = 0;
        }
        for (int c = 1; c <= value.length; c++) {
            for (int r = 1; r <= W; r++) {
                if (weight[c-1] > r) {
                    memo[r][c] = memo[r][c-1];
                } else {
                    memo[r][c] = Integer.max(memo[r][c-1], value[c-1] + memo[r-weight[c-1]][c-1]);
                }
            }
        }
        int maxValue = memo[W][value.length];
        return memo;
    }

    public static List<Integer> knapsackItems(int[][] memo, int[] weight, int W, int c, List<Integer> items) {
        if (c < 1 || W == 0) {
            return items;
        }
        if (memo[W][c] > memo[W][c-1]) {
            items.add(c);
            return knapsackItems(memo, weight, W - weight[c], c-1, items);
        } else {
            return knapsackItems(memo, weight, W, c-1, items);
        }
    }
}
