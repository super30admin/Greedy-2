
/**
 * https://leetcode.com/problems/queue-reconstruction-by-height/
 * 
 * Sort people by descending height and ascending number of people(k) in front of them
 * add the sorted people in the result list at location = number of persons infront of them.
 * This will slide other elements after that index
 *
 */

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0) return new int[0][0];
        
        Arrays.sort(people, (a,b) -> {
           if(a[0] == b[0]){ //if height is same 
               return a[1] - b[1]; //sort ascending by count k
            } else {
               return b[0] - a[0]; //sort descending by height
           }
        });
        
        List<int[]> res = new ArrayList<>();
        
        for(int[] person: people){
        	//add the sorted people in the result list at location = number of persons infront of them.
            res.add(person[1], person);
        }
        
        return res.toArray(new int[0][]);
    }
}