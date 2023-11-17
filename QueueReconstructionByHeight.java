import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionByHeight {
    //Time complexity: O(NlogN)
    //Space Complexity: O(1)
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b)->{
            if(a[0] == b[0]) return a[1]-b[1];
            return b[0] - a[0];
        });
        List<int[]> list = new ArrayList<>();
        for(int i =0; i< people.length; i++){
            list.add(people[i][1], people[i]);
        }

        return list.toArray(new int[list.size()][]);
    }
}