import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Time Complexity: O(nlog(n)) + O(n^2)
// Space Complexity: O(n)


public class problem2 {
    public int[][] reconstrcutQueue(int[][] people)
    {
        Arrays.sort(people, (a,b)->{
            if (b[0]==a[0])
            {
                return a[1]-b[1];
            }
            return b[0]-a[0];
        });
        List<int[]> result= new ArrayList<>();
        for (int [] p:people)
        {
            result.add(p[1],p);
        }
        return result.toArray(new int[0][0]);
    }
}

