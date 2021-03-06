class Solution {
    public int leastInterval(char[] tasks, int n) {
    
        if(tasks.length == 0 || tasks == null)
            return 0;
        HashMap<Character,Integer> hmap = new HashMap<>();
        int maxFrequency = 0;
        for(char c:tasks){
            if(!hmap.containsKey(c)){
                hmap.put(c,0);
            }
            int cnt = hmap.get(c);
            cnt++;
            maxFrequency = Math.max(maxFrequency,cnt);
            hmap.put(c,cnt);
        }
        //Identifying how many elements are there with the maxFrequencies
        int maxCount = 0;
        for(int val:hmap.values()){
            if(val == maxFrequency)
                maxCount++;
        }
        int partitions = maxFrequency - 1;
        // empty holds the num of empty spots we have after placing the tasks with max frequencies
        int empty = (n  - (maxCount - 1))* partitions;
// available holds the number of tasks that are yet to be scheduled
        int available = tasks.length - (maxFrequency * maxCount);
    // if we have a negative value for the empty - available, we choose a 0
        int idle = Math.max(0,empty - available);
        return tasks.length + idle;
         
    }
}

//Time Complexity: O(n)
//Space complexity: O(1) max 26 chars will be stored
