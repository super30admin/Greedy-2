// Time Complexity : O(nlogn + n^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, in converting arraylist to array

// Your code here along with comments explaining your approach
// Sort in decreasing order of height
// Then start scheduling by inserting them into result array based on 2nd index
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> li = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> {
        if(a[0]==b[0]) return a[1]-b[1];
        return b[0]-a[0];});
        for(int i=0;i<people.length;i++) pq.add(people[i]);
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            li.add(temp[1],temp);
        }
        return li.toArray(new int[people.length][2]);
    }
}