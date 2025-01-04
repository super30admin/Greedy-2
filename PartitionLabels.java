// Approach : First create a map with last occurence position of each character because same character should not be repeated in other partition.
// Since we are creating partition strings so need to form a window (start,end)
// Time : O(N)
// Space : O(1)
class Solution {
    public List<Integer> partitionLabels(String s) {
        // create a map of characters last occurence
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c,i);
        }
        System.out.println(map);
       List<Integer> result  = new ArrayList<>();
       int end = 0; int start=0;
       // Now go over the string and try to form the window with every character with range starting as i to value (end) in map for that charater
       for(int i =0;i<s.length();i++){
        char ch = s.charAt(i);
        end = Math.max(end,map.get(ch));
        if(i==end){
            // partition formed
            result.add(end-start+1);
            // start the new partition
            start=i+1;
        }
       }
       return result; 
    }
}