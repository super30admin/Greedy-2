class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character,Integer> hmap = new HashMap<>();
        //storing the last index of each character in the hashmap
        for(int i=0;i<S.length();i++){
            hmap.put(S.charAt(i),i);
        }
        //maintaining 2 pointers and checking the range of the partition and all the
        //chars in the partition are residing in the end of the partition
        int start = 0;int end =0;
        for(int i = 0; i<S.length(); i++){
            char c = S.charAt(i);
            end = Math.max(end,hmap.get(c));
            if(i == end){
                result.add(end-start +1);
                start = i+1;
            }
        }
        return result;
    }
}

//Time Complexity: O(n)
// Space complexity: O(1) in our hashmap we are atmost storing 26 chars which is a constant
