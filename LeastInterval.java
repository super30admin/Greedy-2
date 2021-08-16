class LeastInterval {
    //time: O(n)
    //space: O(n)
    //did it run successfully on leetcode: yes
    public int leastInterval(char[] tasks, int n) {
        //map to strore count of each character
        HashMap<Character, Integer> map = new HashMap<>();
        //variable to store max frequence
        int maxFreq=0;
        //looping through the tasks
        for(int i=0; i<tasks.length; i++){
            //fetching count for current task
            int count = map.getOrDefault(tasks[i], 0);
            //updating count
            count++;
            //updating max Frequence
            maxFreq = Math.max(maxFreq, count);
            //adding the new count to map
            map.put(tasks[i], count);
        }
        //variable to store count of number of task with max frequency
        int maxFreqCount = 0;
        //looping through the hashmap
        for(int val: map.values()){
            //if current task has value equal to max frequency
            if(val==maxFreq){
                //increement count
                maxFreqCount++;
            }
        }
        
        //getting number of partitions possible
        int partitions = maxFreq - 1;
        //available slots after all the task with max frequency has been scheduled
        int available = (n-(maxFreqCount-1))*partitions;
        //number of remaining tasks all the task with max frequency has been scheduled
        int pending = tasks.length - (maxFreq*maxFreqCount);
        //idle or available slots after the pending tasks have been scheduled
        int idle = Math.max(0, available-pending);
        
        //number of tsk + number of idle slots so that cool down can be enforced
        return tasks.length+idle;
    }
}