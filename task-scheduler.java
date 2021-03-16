//Time Complexity: o(n)
//Space Complexity: o(n)
//Store the maxfreq and count from the hashmap and compute the length req
class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> m = new HashMap<>();
        int maxfreq = 0; int maxcount = 0;
        for(int i = 0; i < tasks.length; i++)
        {
            if(!m.containsKey(tasks[i]))
            {
                m.put(tasks[i], 0);
            }
                m.put(tasks[i], m.get(tasks[i]) + 1);
                int count = m.get(tasks[i]);
                maxfreq = Math.max(count, maxfreq);
        }
        for(int val: m.values())
        {
            if(val == maxfreq)
            {
                maxcount++;
            }
        }
        int partition = maxfreq - 1;
        int space = (n - (maxcount -1)) *  partition;
        int available = tasks.length - (maxfreq * maxcount);
        int idle = Math.max(0, space - available);
        return tasks.length + idle;
    }
}