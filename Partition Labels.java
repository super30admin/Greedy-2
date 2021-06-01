//Time Complexity : O(n)
//Space : o(1). As the hash map would occupy at max 26 characters
// Did this code successfully run on Leetcode :yes
// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        if(s==null||s.length()==0){
            return result;
        }
        //use hashmap to store the last occurence of a particular character
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c,i);
        }
        for(int data : map.values()){
            //System.out.println(data);
        }
        //use start and end pointers to keep track of the partition 
        int start = 0, end = 0, length = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            //end is the maximum between the last occurence of the current character and current occurence
            end = Math.max(end,map.get(c));
            //if index is at the last occurence then find the length of this partition
            if(end == i){
                length = end - start + 1;
                result.add(length);
                start = end + 1;
            }
        }
        return result;
    }
}