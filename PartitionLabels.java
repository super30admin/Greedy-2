// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// First traverse through array and update end index of each character
// Traverse the array and consider end index of that element as the end of partition
// If we get an element within that partition whose end index lies outside the partition, update the partition

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<Integer>();
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for(int i=0;i<n;i++) map.put(s.charAt(i),i);
        int start=0, end=0;
        for(int i=0;i<n;i++){
            end = Math.max(end, map.get(s.charAt(i)));
            if(i==end) {
                result.add(end-start+1); start=i+1;
            }
        }
        return result;
    }
}