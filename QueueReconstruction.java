// Time Complexity :O(n * logn) where n is the length of the people array
// Space Complexity :O(n) where n is the length of the people array
// Did this code successfully run on Leetcode :yes

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class QueueReconstruction {
    public int[][] reconstructQueue(int[][] people) {
        if(people.length < 2){
            return people;
        }

        //sort in decreasing order of height and increasing position
        Arrays.sort(people, (a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }else{
                return b[0] - a[0];
            }
        });

        //iterate through the sorted array and put each person at the right position
        List<int[]> li = new ArrayList<>();
        for(int i =0; i<people.length; i++){
            li.add(people[i][1], people[i]);
        }

        int[][] result = new int[people.length][2];
        for(int i =0; i< li.size(); i++){
            result[i] = li.get(i);
        }
        return result;
    }
}
