// Time Complexity :O(n)
// Space Complexity :O(1), hashMap is considered constant space since we have only 26 alphabets
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// We use a hashMap to store the count of each alphabet
// we maintain variables such as maxfreq, maxcount, partitions, empty, pending, idle and finally return (tasks length + idle)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        if (tasks == null || len == 0) return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int maxfreq = 0, maxcount = 0;

        // we fill the map with the count of each character
        for (char c: tasks) {
            map.put(c, map.getOrDefault(c, 0)+1);
            maxfreq = Math.max(maxfreq, map.get(c));
        }

        // count maxcount
        for (Character c: map.keySet()) {
            if (maxfreq == map.get(c)) {
                maxcount++;
            }
        }

        // we come to the idle slots by calculating the other values
        int partitions = maxfreq-1;
        int empty = partitions * (n-(maxcount-1));
        int pending = len - (maxfreq*maxcount);
        int idle = Math.max(0, empty-pending);

        return len + idle;
    }
}