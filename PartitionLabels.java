Time Complexity = O(n)
Space Complexity = O(n)

class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> partition_length = new ArrayList<>();
        
        int[] index = new int[26];
        for(int i = 0; i < S.length(); i++){
            index[S.charAt(i) - 'a'] = i;
        }
        
        int i = 0;
        while(i < S.length()){
            int end = index[S.charAt(i) - 'a'];
            int j = i;
            while(j != end){
                end = Math.max(end,index[S.charAt(j++) - 'a']);
            }
            
            partition_length.add(j-i+1);
            i = j+1;
        }
        return partition_length;
    }
}