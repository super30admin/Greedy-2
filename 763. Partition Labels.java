class Solution {// Time of O(n) and space of O(constant+ resultList)
    public List<Integer> partitionLabels(String S) {
        
        int[] last = new int[26];
        //Find the last occurance of each char
        
        for(int i = 0; i< S.length() ; i++){
            last[S.charAt(i)-'a'] = i;
        }
        
        List<Integer> result = new ArrayList<>();
        int start =0,end = 0;
        
        for(int i= 0 ; i< S.length(); i++){
            end = Math.max(end,last[S.charAt(i)-'a']);
            if(i ==end){
                result.add(end-start +1);
                start = i+1;
            }
        }
        return result;
    }
}