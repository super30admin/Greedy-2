//Time Complexity: O(n)
//Space Complexity: O(n)

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        //base case
        if(s == null || s.length() == 0)
            return result;
        //consider a map of locations for 26 characters
        int[] map = new int[26];
        //calculating the last index of each character of the string
        //and storing it to the map
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            //update character's last occurence
            map[c - 'a'] = i;
        }
        int start = 0;
        int end = 0;
        //now traversing from the string;
        //for each character, get end position by comparing
        //the current index with the last index from map
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            end = Math.max(end, map[c - 'a']);
            //if i reaches end of 1 partition,
            //add the partition to the result
            //update start variable
            if(end == i){
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}