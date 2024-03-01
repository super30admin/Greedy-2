// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, (o1, o2) -> {
            int hDiff = o2[0] - o1[0];
            if(hDiff == 0){
                return o1[1] - o2[1];
            }
            return hDiff;
        });

        // for(int[] person : people){
        //     System.out.println(person[0] + ", " + person[1]);
        // }

        ArrayList<int[]> list = new ArrayList<>();

        for(int[] person : people){
            list.add(person[1], person);
        }

        for(int i = 0; i < people.length; i++){
            people[i] = list.get(i);
        }

        return people;


        
    }
}
