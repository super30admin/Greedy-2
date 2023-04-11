import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
/*
Queue reconstruction by height
approach: person with maximum height and less number of people he is allowing should be placed first and same for others
time: O(n^2)
space: O(n)
 */
public class Problem3 {
    public int[][] reconstructQueue(int[][] people) {
//        sort people based on heights, if heights are equal then sort based people they;re allowing to be infront
        Arrays.sort(people, (a,b) -> {
            if (a[0]==b[0]) return a[1]-b[1];
            else return b[0]-a[0];
        });

//        now place the people according to the number of people they're allowing to stand infront of them
        ArrayList<int[]> res = new ArrayList<>();
        for (int i = 0;i<people.length;i++) {
            int curr[] = people[i];
            res.add(curr[1], curr);
        }
        int[][] result = new int[people.length][2];
        int i = 0;
        for (int[] arr: res) {
            result[i++] = arr;
        }
        return result;
    }
}
