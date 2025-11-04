/*
* Approach: The idea is to find how many idle cpus will be there in order to finish the given tasks
- Firstly, we need to be greedy and look for most critical or highest freq tasks and how many highfreq tasks are there
- Then calculate the partitions, available slots, pending tasks and idle state
    - consider ex1: maxFreq = 3, totalmaxFreqTasks = 2 and n = 2
    A _ _ A _ _ A -> from this, we can calculate 
    - partitions:  2 -> maxFreq - 1;
    - available slots: partitions * (n - (totalmaxFreqTasks - 1)) -> 4 slots -> if there are two maxFreq tasks, we need to put them together to get the local minima, resulting into global minima. 
    - pending tasks: once all high freq tasks are done, we will have tasks remaining -> task.length - (maxFreq * totalmaxFreqTasks)
    - idle: max of (0, (available slots - pending)), max because if the answer is negative that means we dont have any idle cpu so in that case the number of idle cpus should be 0 and not negative because that will mean we are producing extra timelol
- Finally, return the total number of tasks + idle cpu intervals
TC: O(n) -> iterate over tasks array to count maxFreq and iterate over keySet to get totalnumofmaxtasks
SC: O(n) -> worst case for storing tasks and its freq
 */
class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int numOfMaxFreqTasks = 0;
        for(char c: tasks){
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(c));
        }
        for(char k: map.keySet()){
            if(map.get(k) == maxFreq)
                numOfMaxFreqTasks++;
        }

        int partitions = maxFreq - 1;
        int availableSlots = partitions * (n - (numOfMaxFreqTasks - 1));
        int pendingTasks = tasks.length - (maxFreq * numOfMaxFreqTasks);
        int idle = Math.max(0, (availableSlots - pendingTasks));

        return tasks.length + idle;
    }
}