// Time Complexity : O(N)
// Space Complexity : O(1) :: Since we use Map of 26 chars only
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int leastInterval(char[] tasks, int n) {

        // Frequency Map
        Map<Character, Integer> map = new HashMap<>();

        int maxF = 0; // MAX frequency
        int maxFE = 0; // Total Number of elements with Max Frequency - we will group them
        for (char c : tasks) {
            int count =  map.getOrDefault(c, 0);
            count++;
            map.put(c, count);
            maxF = Math.max(maxF, count);
        }

        for (char c : map.keySet()) {
            if (map.get(c) == maxF) maxFE++;
        }

        // Mathematics
        int k = n - (maxFE - 1); // This is effective n
        if (k < 0) k = 0;

        int slots = (maxF - 1) * k; // total slots
        int pendingElements = tasks.length - (maxFE * maxF);
        int Idle = Math.max(0, (slots - pendingElements));
        int ans = tasks.length + Idle;
        return ans;
    }
}