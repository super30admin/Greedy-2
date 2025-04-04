import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TC-O(n^2)  SC- O(n)
public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
           List<int []> result = new ArrayList<>();
        for(int [] p : people){
            result.add(p[1], p);
            System.out.println("p[1]"+p[1]);
        }
      return result.toArray(new int [0][]);
    }
}
