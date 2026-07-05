// Time Complexity : O(n) because we count frequencies and scan the map once
// Space Complexity : O(1) since there are at most 26 task types
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We arrange the most frequent tasks first, creating partitions between them.
// These partitions create slots that must be filled by other tasks or remain idle.
// The total time is the number of tasks plus any extra idle slots required.

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxCount = 0;
        int maxFrequency = 0;

        // count frequencies and find maximum frequency
        for(char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFrequency = Math.max(maxFrequency, map.get(c));
        }

        // count how many tasks have max frequency
        for(char c : map.keySet()) {
            if(map.get(c) == maxFrequency) {
                maxCount++;
            }
        }

        // partitions formed between most frequent tasks
        int partitions = maxFrequency - 1;

        // slots available for remaining tasks
        int availableSlots = partitions * (n - (maxCount - 1));

        // tasks left after placing max frequency tasks
        int pending = tasks.length - (maxFrequency * maxCount);

        // idle slots needed
        int idle = Math.max(0, availableSlots - pending);

        return tasks.length + idle;
    }
}
