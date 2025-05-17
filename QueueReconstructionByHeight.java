import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TC: n*n
//SC: O(n)
class QueueReconstructionByHeight {
  public int[][] reconstructQueue(int[][] people) {
      List<int []> res=new ArrayList<>();
      Arrays.sort(people,(a,b)->{
          if(a[0]==b[0]){
              return a[1]-b[1];
          }
          return b[0]-a[0];
      });
      for(int[] person:people){  // putting at particular index n*n
          res.add(person[1],person);
      }
      return res.toArray(new int[0][]);
  }
}