// Time complexity :O(n)
// Space Complexity :O(n)
class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for(int i=0;i<S.length();i++){
            last[S.charAt(i)-'a']=i;
        }
        List<Integer> result = new ArrayList<>();
        int start=0,end=0;
        for(int i=0;i<S.length();i++){
            end = Math.max(end,last[S.charAt(i)-'a']);
            if(i==end){
                result.add(end-start+1);
                start=i+1;
            }
        }
        return result;
    }

}