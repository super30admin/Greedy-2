// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//We store the last occurence of each character in an Hashmap for faster lookup
//Iterate over the string and check if the occurence of each falls within the max occurence if yes we get the partition size
//and move my start pointer from next index after a partition is found
class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        //get the last occurence of each character in S
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, i);
        }
        int start = 0;
        int end = 0;
        List<Integer> li = new ArrayList<>();
        //iterate over the string to get the partitions
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            end = Math.max(end, map.get(ch));
            if (i == end) {
                //found a partition
                li.add(end - start + 1);
                start = i + 1;
            }
        }
        return li;

    }
}
