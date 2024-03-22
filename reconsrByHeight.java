import java.util.*;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // Tc: O(n^2) Sc: O(n)
        List<int[]> res = new ArrayList<>();

        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return b[0] - a[0];
        });

        for (int[] person : people) {
            res.add(person[1], person);
        }
        int arr[][] = new int[people.length][people[0].length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}