import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TC: O(n ^ 2 + n logn), SC: O(1)
public class QueueReconstruction {

    public int[][] reconstructQueue(int[][] people) {
        final List<int[]> queue = new ArrayList<>();

        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });

        for (int[] person: people) queue.add(person[1], person);

        return queue.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        final QueueReconstruction queueReconstruction = new QueueReconstruction();

        //[5,0], [7, 0], [5, 2], [6, 1], [4, 4], [7, 1]
        System.out.println(
                Arrays.deepToString(
                        queueReconstruction.reconstructQueue(
                                new int[][] {
                                        {7, 0},
                                        {4, 4},
                                        {5, 0},
                                        {5, 2},
                                        {6, 1},
                                        {7, 1}
                                }
                        )
                )
        );
    }
}
