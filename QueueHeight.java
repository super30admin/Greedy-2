// Time Complexity : O(n^2) where n is number of tasks
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class QueueHeight {
    public int[][] reconstructQueue(int[][] people) {
        List<int []> result = new ArrayList<>();
        Arrays.sort(people, (a,b) -> {
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return b[0]-a[0];
        });
        for(int [] person: people){//O(n^2)
            result.add(person[1],person);
        }
        int [][] arr = new int[people.length][2];
        for(int i=0;i<arr.length;i++){
            arr[i]=result.get(i);
        }
        return arr;
    }

    public static void main(String[] args){
        QueueHeight qh = new QueueHeight();
        System.out.println(Arrays.deepToString(qh.reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}})));
    }
}