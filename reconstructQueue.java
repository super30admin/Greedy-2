
// Time Complexity : O(n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
import java.util.*;

class Main {
    // approch 1 greedy
    public static int[][] reconstructQueue(int[][] people) {
        // null case
        if (people == null || people.length == 0)
            return new int[][] {};
        int n = people.length;
        // to store the result
        List<int[]> li = new ArrayList<>();
        // sort by tallest to smallest
        Arrays.sort(people, (a, b) -> {
            // if height is same sort by prefrence of number of people before
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            // desc height
            return b[0] - a[0];
        });
        // for loop for reconstuction
        for (int[] p : people) {
            li.add(p[1], p);
        }
        // list to array
        int[][] result = li.toArray(int[][]::new);
        return result;

    }

    public static void main(String[] args) {
        int[][] people = new int[][] { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
        int[][] result = reconstructQueue(people);
        for (int[] r : result) {
            System.out.println(Arrays.toString(r));
        }
    }
}