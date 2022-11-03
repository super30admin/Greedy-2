// Time Complexity : O(n)
// Space Complexity : O(26) ~= O(1)
// n is the length of given char array tasks
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int leastInterval(char[] tasks, int k) {
        int maxFreq = 0;
        int maxCount = 0;
        HashMap<Character,Integer> map = new HashMap<>();

        for(char task : tasks){
            if(!map.containsKey(task)){
                map.put(task,0);
            }
            int cnt = map.get(task);
            cnt++;
            maxFreq = Math.max(maxFreq,cnt);
            map.put(task,cnt);
        }

        for(Character task : map.keySet()){
            if(map.get(task) == maxFreq){
                maxCount++;
            }
        }

        int partitions = maxFreq-1;
        int availableSlots = partitions * (k - (maxCount -1));
        int pendingTask = tasks.length - (maxFreq * maxCount);
        int emptySlots = Math.max(0,availableSlots - pendingTask);

        return tasks.length + emptySlots;
    }
}