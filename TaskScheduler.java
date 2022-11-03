class Solution {
    //tc-o(n) //sc-o(1)
    public int leastInterval(char[] tasks, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int maxFreq = 0;
        int maxCount =0;
        for(Character task : tasks)
        {
            if(!map.containsKey(task))
            {
                map.put(task,0);
            }
            int cnt = map.get(task);
            cnt++;
            maxFreq = Math.max(maxFreq,cnt);
            map.put(task,cnt);

        }
        for(Character task : map.keySet())
        {
            if(map.get(task) == maxFreq)
            {
                maxCount++;
            }
        }
        int partitions = maxFreq - 1;
        int available = partitions*(k-(maxCount-1));
        int pending = tasks.length - (maxFreq*maxCount);
        int empty = Math.max(0,available-pending);

        return tasks.length + empty;
    }
}