// Time Complexity : O(N^2 + Nlog(N)
// Space Complexity : O(N)
import java.util.*;
public class QueueReconstructionByHeight {
    static int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        Arrays.sort(people, (a,b)-> {
            if(a[0] == b[0]) return a[1]-b[1];
            return b[0]-a[0];
        });

        List<int[]> sol = new ArrayList<>();
        for(int[] p: people) {
            sol.add(p[1], p);
        }

        int[][] res = new int[n][];
        for(int i = 0; i < n; i++) {
            res[i] = sol.get(i);
        }

        return res;
    }
    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        System.out.println("Queue before reconstruction:");
        for(int[] p : people) {
            System.out.println(Arrays.toString(p));
        }
        int[][] res = reconstructQueue(people);
        System.out.println("Queue After reconstruction:");
        for(int[] r : res) {
            System.out.println(Arrays.toString(r));
        }

    }
}
