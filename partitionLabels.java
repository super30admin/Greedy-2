// Problem3 Partition Labels (https://leetcode.com/problems/partition-labels/)

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, take hashmap with last index of each character. Iterate through the string and have a startIndex and lastIndex initially at 0 and
 * take lastIndex as max(lastIndex, map.get(ch)) and when i == lastIndex, add lastIndex - startIndex + 1 to result and startIndex = i+1.
 * Finally return result.
 */
class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch, i);
        }
        int lastIndex = 0;
        int startIndex = 0;
        for(int i = 0; i< s.length(); i++){
            char ch = s.charAt(i);
            lastIndex = Math.max(lastIndex, map.get(ch));
            if(i == lastIndex){
                result.add(lastIndex - startIndex + 1);
                startIndex = i + 1;
            } 
        }
        return result;
    }
}