// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We find the last position of each character in the string and place it in the map. Now, we determine the
end pointer by taking the farthest index for any character we have seen so far. If our i reaches the end,
we update our result list and reinitialize our start to i's next position by making a partition there.
 */
class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        List<Integer> result = new ArrayList<>();

        for(int i = 0 ; i < s.length() ; i++) {
            char ch = s.charAt(i);
            map.put(ch, i);
        }

        for(int i = 0 ; i < s.length() ; i++) {
            char ch = s.charAt(i);
            end = Math.max(end, map.get(ch));

            if(i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }
        return result;
    }
}