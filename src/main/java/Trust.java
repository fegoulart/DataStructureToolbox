import java.util.*;

public class Trust {
    public static void main(String[] args) {
        int N = 4;
        int[][] trust = {{1, 3}, {3, 4}};
        System.out.println(teste(N, trust));
    }

    public static int teste(int N, int[][] trust) {
        TreeMap<Integer, List<Integer>> town = populateMapWithKeyAsTrusted(N, trust);
        for (int x = 1; x <= N; x++) {
            try {
                List<Integer> citizen = town.get(x);
                if (citizen.size() == 0) {
                    return x;
                }
            } catch (Exception ex) {
                return x;
            }
        }
        return -1;
    }

    public static TreeMap<Integer, List<Integer>> populateMapWithKeyAsTrusted(int N, int[][] trust) {
        TreeMap<Integer, List<Integer>> town = createInitializedTreeMap(N);
        for (int i = 0; i < trust.length; i++) {
            town.get(trust[i][1]).add(trust[i][0]);
        }
        return town;
    }

    public static TreeMap<Integer, List<Integer>> createInitializedTreeMap(int N) {
        TreeMap<Integer, List<Integer>> town = new TreeMap<>();
        for (int j = 1; j <= N; j++) {
            List<Integer> citizen = new ArrayList<Integer>();
            town.put(j, citizen);
            System.out.println(j + " " + citizen);
        }
        return town;
    }
}
