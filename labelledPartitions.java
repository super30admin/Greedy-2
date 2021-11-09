// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class labelledPartitions {
    public List<Integer> partitionLabels(String S) {
        
        int n = S.length();
        HashMap<Character,Integer> map = new HashMap<>();
         
        for(int i = 0; i < n; i++){
             map.put(S.charAt(i), i);
         }
         
         int len = 0;
         int end = -1;
         List<Integer> list = new ArrayList<>();
         
         for(int i = 0; i < n; i++){
             char ch = S.charAt(i);
             int lastOccurance = map.get(ch);
             end = Math.max(end, lastOccurance);
             len++;
             
             if(i == end){
                 list.add(len);
                 len = 0;
             }
         }
         return list;
     }
}