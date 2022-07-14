import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Time Complexity : O(N^2)
//Space Complexity : O(N)
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int [] > li = new ArrayList<>();
        //Sort people
        Arrays.sort(people,(a,b) ->{
            if(a[0]==b[0]) return a[1]-b[1];
            return b[0]-a[0];
        });
        //add to list based on number of people infront
        for(int [] person : people){
            li.add(person[1],person);
        }
        return li.toArray(people);
    }
}