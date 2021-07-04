import java.util.*;

public class QueueRearranging {

   
    public int[][] reconstructQueue(int[][] people) {
        System.out.println("Before: ");
        print(people);
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        System.out.println("After: ");
        print(people);
        List<int[]> result = new ArrayList<>();

        for (int[] p : people) {
            result.add(p[1], p);
        }
        return result.toArray(new int[0][]);

    }

    public static void main(String[] args) {
        QueueRearranging queueRearranging = new QueueRearranging();
        int[][] people = new int[][] {
            {7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}
        };
        int[][] result = queueRearranging.reconstructQueue(people);
        System.out.println("The result: "+result);
    }

    private void print(int[][] arr) {
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[0].length;j++) {
                System.out.println(arr[i][j]);
            }
        }
    }
}
