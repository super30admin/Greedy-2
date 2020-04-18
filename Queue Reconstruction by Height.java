// Time Complexity :nlogn+o(n*n) =o(n^2)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Comparator<int[]> comp=new Comparator<>(){
            @Override
            public int compare(int[] a,int[] b){
                if(a[0]==b[0]){
                    return a[1]-b[1];
                }
                else{
                 return b[0]-a[0];   
                }
            }
        };
        
        Arrays.sort(people,comp);
        LinkedList<int[]> lst=new LinkedList<>();
       
        for(int[] ppl:people){
            lst.add(ppl[1],ppl);
        }
        return lst.toArray(new int[0][2]);
    }
}