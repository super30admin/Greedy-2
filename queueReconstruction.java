// Time Complexity: O(NlogN)
// Space Complexity: O(1)

import java.util.*;

class QSolution {

    public int[][] reconstructQueue(int[][] people) {
        //[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
        Arrays.sort(people, (a,b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        // [7, 0] [7,1][5,0][5,2] [4,4]

        List <int []> result = new ArrayList<>();

        for(int [] p : people){

            result.add(p[1], p);

        }
        return result.toArray(new int [0][]);
    }


    public static void main(String[] args)
    {
        QSolution q = new QSolution();
        int[][] ppl =  {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        q.reconstructQueue(ppl);
    }

}