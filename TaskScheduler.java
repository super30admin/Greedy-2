// Time Complexity : O(n)
// Space Complexity : O(1) : 26 characters only
// Did this code successfully run on Leetcode : yes

//Approach: key is to find number of required idle slots, and assign all tasks with maxFreq(GREEDY) together. Such that all bottlnecks tasks are scheduled first.

// Your code here along with comments explaining your approach

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map = new HashMap<>();
        int l = tasks.length;
        int maxFreqTasks = 0;
        int maxFreq = 0;

        for(int i = 0; i < l; i++){
            char t = tasks[i];
            map.put(t,map.getOrDefault(tasks[i],0)+1);
            //found new bottle neck
            if(map.get(t) > maxFreq){
                maxFreq = map.get(t);
                maxFreqTasks = 1;
            }
            else if( map.get(t) == maxFreq){
                maxFreqTasks++;
            }
        }

        int partitions = maxFreq-1;
        int emptySlots = partitions * (n - (maxFreqTasks-1)); //Bottle neck tasks can be used in cooling period slots, and -1 because one bottle neck task is already used.
        int pendingTasks = l - (maxFreq * maxFreqTasks);
        int idleSlots = Math.max(0, emptySlots - pendingTasks);

        return l + idleSlots;
    }
}