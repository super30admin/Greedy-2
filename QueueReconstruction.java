/*
TC: O(NlogN)- sort, insert N values into list O(N) = O(N^2)
SC: O(1) no extra space

1. Sort the array based on 
        a. Decreasing orer of height
        b. If same height, increasing order of k
2. Add the people based on k. K acts as index in output array.

*/

import java.util.*;

public class QueueReconstruction {
    public int[][] reconstruct(int[][] people){
        Arrays.sort(people, (a,b)-> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> output = new ArrayList<>();

        for(int[] p : people){
            output.add(p[1], p);
        }

        return output.toArray(new int[0][]);

    }

    public static void main(String[] args){
        QueueReconstruction qr = new QueueReconstruction();
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        System.out.println(qr.reconstruct(people));
    }
}
