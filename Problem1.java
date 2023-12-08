//Time Complexity : O(n)
//Space Complexity: O(n)

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int noOfTasksWithMaxFreq = 0;
        for(char task : tasks){
            map.put(task, map.getOrDefault(task,0)+1);
            maxFreq = Math.max(maxFreq,map.get(task));
        }
        for(char task: map.keySet()){
            if(map.get(task) == maxFreq){
                noOfTasksWithMaxFreq++;
            }
        }
        int partitions = maxFreq-1;
        int available = partitions*(n-(noOfTasksWithMaxFreq - 1));
        int pending = tasks.length - (maxFreq * noOfTasksWithMaxFreq);
        int idle = Math.max(0, available - pending);
        return tasks.length + idle;
    }
}
