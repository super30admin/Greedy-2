class Solution {
	//Time: Linear
	//Space: n, for the map
    public List<Integer> partitionLabels(String s) {
        
        int[] lastIndices = new int[26];
        LinkedList<Integer> partitions = new LinkedList();
        
        //Formed an array containing last index of each symbol.
        
        for(int i = 0; i < s.length(); i++){
            
            lastIndices[s.charAt(i) - 'a'] = i;
            
        }
        
        //The following part is very tricky
        //I would suggest you to repeat this question without looking at the solution.
        int i = 0;
        
        while(i < s.length()){
            int end = lastIndices[s.charAt(i) - 'a'];
            
            int j = i;
            
            while(j != end){
                end = Math.max(lastIndices[s.charAt(j) - 'a'], end);
                j++;
            }
            partitions.add(j - i + 1);
            i = j + 1;
        }
        
        return partitions;
    }
}