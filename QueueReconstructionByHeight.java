import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        // sort by height decending and then ki in asending order
        // then swap lower heights with ki to ki index
        Arrays.sort(people, (a, b)-> {
            if(a[0] == b[0])
            {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });
        List<int[]> result = new ArrayList<>();
        for(int[] queueElem : people)
        {
            result.add(queueElem[1], queueElem);
        }
        return result.toArray(new int[0][0]);
    }
}