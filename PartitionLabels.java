class PartitionLabels {
    //time: O(n)
    //space: O(1) since max character in hashma will be 26
    //did it run successfully on leetcode: yes
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        //creating a map of characters and its last inde
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), i);
        }
        
        //intializing start and end of our partition
        int start = 0, end=0;
        //an array to store partitions
        List<Integer> res = new ArrayList<>();
        //looping through the input strinh
        for(int i=0; i<s.length(); i++){
            //getting current character
            Character c = s.charAt(i);
            //updates end if current character last index is greater
            end= Math.max(end, map.get(c));
            //if we reach the last index
            if(i==end){
                //Add partition length to result
                res.add(end-start+1);
                //update start
                start = end+1;
            }
        }
        return res;
        
    }
}