// Time complexity - O(n)
// Space Complexity - O(1)
// Tested in leetcode

class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        // Allocate hashmap to store last index of each char of the string
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<S.length();i++){
            char c = S.charAt(i);
            map.put(c,i);
        }
        List<Integer> result = new ArrayList<>();
        int start =0, end=0;
        //part the string when iterator is reached upto the index pointed by end variable, point start next to end and repeat.
        for(int i=0; i<S.length();i++){
            char c = S.charAt(i);
            end = Math.max(end,map.get(c));
            if(i == end){
                result.add(end-start+1);
                start = end+1;
            }
        }
        return result;
    }
}

