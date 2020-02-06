/**
LeetCode Submitted : YES
Time Complexity : O(N^2) //because of adding in list at releveant index
Space Complexity : O(1)

The idea is to sort the people 2-d array first decreasing order on the height and then on the second index (i.e. number of people in ascending oreder) such that we now get initial exact positions (upper bound) of the people in the queue. Then iterate each people in the array and add it to appropriate index. The trick here is sorting (descending on 1st index and ascending on 2nd index). 
**/

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        
        List<int[]> result = new ArrayList<>();
        if(people == null || people.length < 1)
            return people;
        
        //Sorting the people 2-D arrays (Descending on first index and ascending on second Index)
        Arrays.sort(people,(a,b) -> a[0] == b[0] ? Integer.compare(a[1],b[1]) :Integer.compare(b[0],a[0]));
        
        for(int[] p : people){
            result.add(p[1],p);
        }
        //get the list into 2-D Array
        return result.toArray(new int[0][]); 
    }
}
