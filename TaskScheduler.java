class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        
        //Storing task and its associated freq
        for(int i = 0; i < tasks.length; i++){
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(tasks[i]));
        }
        
        int count = 0;
        
        //Finding the num of tasks with max freq
        for(int val: map.values()){
            if(val == maxFreq){
                count++;
            }
        }
    
        int partitions = maxFreq - 1;
        int Empty = partitions * (n - count + 1);
        int pending = tasks.length - maxFreq * count;
        int Idle = Math.max(Empty - pending, 0);
        
        return tasks.length + Idle;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)