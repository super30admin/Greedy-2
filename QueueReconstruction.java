// Time Complexity :O(N^2)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int[][] reconstructQueue(int[][] people) {
       if(people==null || people.length==0) return new int[0][0];
        List<int[]> result = new LinkedList<>();
        Comparator<int[]> customComparator = new Comparator<>(){
            public int compare(int[] a, int[] b){
                if(a[0]==b[0]) return a[1]-b[1];
                return b[0]-a[0];
            }
        };
        
        
        Arrays.sort(people,customComparator);
        
        for(int i = 0;i<people.length;i++){
            result.add(people[i][1],people[i]);
        }
        
        return result.toArray(new int[0][2]);
    }
}