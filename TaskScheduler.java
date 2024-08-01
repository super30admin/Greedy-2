// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Count Frequencies: Determine the maximum frequency of any task and count how many tasks have this maximum frequency.
//Calculate Empty Slots: Compute the number of empty slots between partitions created by the most frequent tasks, factoring in the cooldown period n.
//Determine Total Time: Calculate the total time as the sum of the length of tasks and idle slots required to meet the cooldown condition.

class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0){
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int max_freq = 0 , max_count = 0;

        for(char c : tasks){
            map.put(c, map.getOrDefault(c,0)+1);
            max_freq = Math.max(max_freq, map.get(c));
        }

        for(char c: map.keySet()){
            if(map.get(c) == max_freq){
                max_count++;
            }
        }

        int partitions = max_freq - 1;
        int empty_slots = partitions *(n - (max_count - 1));
        int pending = tasks.length - (max_freq * max_count);
        int idle_slots = Math.max(0,empty_slots - pending);
        int total = tasks.length + idle_slots;
        return total;
    }
}