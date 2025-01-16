import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstruction {
     public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }else{
                return b[0] - a[0];
            }
        });
        List<int[]> output = new LinkedList<>();
        int n = people.length;
        for(int[] p: people){
            output.add(p[1], p);
        }
        return output.toArray(new int[n][2]);
    }
}
