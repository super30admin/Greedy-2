import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Time Complexity=O(n^2)
//Space Complexity=O(n)
public class QueueReconstruction {

    public int[][] reconstructQueue(int[][] people) {

        List<int[]> result=new ArrayList<>();

        Arrays.sort(people,(a, b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return b[0]-a[0];
        });

        for(int[] person:people){
            result.add(person[1],person);
        }

        return result.toArray(new int[0][]);
    }
}
