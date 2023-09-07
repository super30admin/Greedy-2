// Time Complexity : O(n log n) + O(n^2)
// Space Complexity : O(n) (if list is considered) else O(1)
// Did this code successfully run on Leetcode : Yes

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReConstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        int result[][] = new int[people.length][2];
        List<int[]> li = new ArrayList<>();
        Arrays.sort(people, (a, b)->{       // n log n
            if(a[0] == b[0])
            {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        for(int[] p : people){  // n^2
            li.add(p[1],p);
        }

        for(int i=0; i<li.size(); i++)
        {
            result[i] = li.get(i);
        }

        return result;
    }
}
