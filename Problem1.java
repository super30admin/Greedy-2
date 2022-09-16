//Time Complexity: O(n)
//Space Complexity: O(1)
//Code run successfully on LeetCode.

public class Problem1 {

    public int leastInterval(char[] tasks, int n) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        int l = tasks.length;
        int maxFrequency =0, maxCount =0;
        
        for(int i =0; i <l; i++)
        {
            char c = tasks[i];
            map.put(c, map.getOrDefault(c,0) +1);
            int val = map.get(c);
            maxFrequency = Math.max(maxFrequency, val);
        }
        
        for(char c : map.keySet())
        {
            if(map.get(c) == maxFrequency)
                maxCount++;
        }
        
        int partition = maxFrequency -1;
        int empty = partition * (n - (maxCount - 1));
        int incompleteTasks = l - (maxFrequency * maxCount);
        int idle = Math.max(empty - incompleteTasks, 0);
        
        int result = l + idle;
        return result;
    }
}
