/*
Time: O(N^2) where N is number of people in queue( O(NlogN) for sort and for each insert, remaining 
elements are displaced by one in the worst cases, which takes O(N) worst case time. So, O(N^2)
Space: O(1) 
Approach:
========
1. Sort using custom comparator where people are first ordered by their height in descending and then by 
their k values in ascending order if of same height
2. Insert every person at index mentioned as k values, which places them in correct position
*/
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0) return new int[][]{}; 
           
        // custom comparator (order first by descending order of height and if equal height, then ascending 
        //order of k)   
        Comparator<int[]> customComp = new Comparator<>() {
           @Override
           public int compare(int[] p1, int[] p2) {
               if(p1[0] == p2[0])
                   return p1[1] - p2[1]; 
               else
                   return p2[0] - p1[0]; 
           } 
        }; 
        
        //sort people array using custom comparator
        Arrays.sort(people, customComp); 
        
        //now, insert every person at index mentioned in p[1]. This places it in correct position
        List<int[]> result = new LinkedList<>(); 
        for(int[] p: people) {
            result.add(p[1], p);
        }
        
        //convert to array
        return result.toArray(new int[people.length][2]); 
    }
}