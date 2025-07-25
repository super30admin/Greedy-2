//Time Complexity: O(n)
//Space Complexity: O(1)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        for(char task : tasks){
            map.put(task, map.getOrDefault(task, 0)+1);
            maxFreq = Math.max(maxFreq,map.get(task));
        }
        int maxNumber = 0;
        for(char task: map.keySet()){
            if(map.get(task) == maxFreq){
                maxNumber += 1;
            }
        }
        int partitions = maxFreq -1;
        int available =partitions*(n -(maxNumber -1));
        int pending = tasks.length - (maxNumber * maxFreq);
        int idle = Math.max(0, available - pending);

        return tasks.length + idle;
    }
}
