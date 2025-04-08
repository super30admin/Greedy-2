class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> map = new HashMap<>();
        int maxFreq=0;
        for(char task: tasks)
        {
            map.put(task,map.getOrDefault(task,0)+1);
            maxFreq = Math.max(maxFreq,map.get(task));
        }
        int maxCount =0;
        for(char key: map.keySet())
        {
            if(map.get(key) == maxFreq)
            {
                maxCount++;
            }
        }
        int partitions = maxFreq-1;
        int availableslots = partitions* (n-(maxCount-1));
        int pending = tasks.length - (maxCount*maxFreq);
        int idle = Math.max(0,availableslots-pending);

        return tasks.length+idle;
    }
}

//tc: O(n) wher en is the length of the task array
//sc: O(n)