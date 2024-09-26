// Time Complexity :o(n)
// Space Complexity :o(1) - is we know space is constant which is o(26) 
//then we can consider it has o(2)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> partitionLabels(String S) {
        int start=0;
        int end=0;
        List<Integer> lst=new ArrayList<>();
        int[] lastindex=new int[26];
        for(int i=0;i<S.length();i++){
            lastindex[S.charAt(i)-'a']=i;
        }
        for(int i=0;i<S.length();i++){
            end=Math.max(lastindex[S.charAt(i)-'a'],end);
            
            if(i==end){
                lst.add(end-start+1);
                start=end+1;
            }
        }
        return lst;
    }
}