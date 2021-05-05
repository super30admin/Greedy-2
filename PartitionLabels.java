class PartitionLabels {

    // Time Complexity: O(n)    (where n -> length of the string)
    // Space Complexity: O(1)
    
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        int[] last = new int[26];
        for(int i = 0; i < S.length(); i++){
            last[S.charAt(i) - 'a'] = i;
        }
        
        int start = 0;
        int end = 0;
        for(int i = 0; i < S.length(); i++){
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if(i == end){
                result.add(end - start + 1);
                start = i+1;
            }
        }
        return result;
    }
}