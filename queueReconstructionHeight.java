// Time Complexity : O(N^2)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : After class solution


// Your code here along with comments explaining your approach

//Use custom comparator to sort the arrays using two conditions: a) if the heights are equal, then sort by occurance, else b) sort by height
//Use linkedlist to add the elemnts based on index/occurance
//Convert the linkedlist to array


class Solution {
    
    public int[][] reconstructQueue(int[][] people) {
        
        if(people == null || people.length == 0) return new int[0][0];
        
        Comparator<int[]> customComparator = new Comparator<>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]){
                    return a[1] - b[1];
                }else{
                    return b[0] - a[0];
                }
            }
        };
        
        Arrays.sort(people, customComparator);
        
        List<int[]> result = new LinkedList<>();
        
        for(int[] p: people){
            result.add(p[1], p);
        }
        
        return result.toArray(new int[people.length][2]);
    }
}
