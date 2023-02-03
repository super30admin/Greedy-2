//https://leetcode.com/problems/queue-reconstruction-by-height
//TC : O(n*n)
//SC: O(n)

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        Arrays.sort(people,(a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return b[0]-a[0];
        }); // nlogn
        List<int []> list = new ArrayList<>();
        for(int[] i : people){
            list.add(i[1],i);
        } // n^2
        int [][] result = new int[n][];
        for(int i=0;i<n;i++){
            result[i] = list.get(i);
        }
        return result;
    }
}
