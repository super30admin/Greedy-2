// TC: O(N) -> N: tasks.length
// SC: O(1)
// Did it sun successfully on Leetcode? : Yes
class Solution {
    public int leastInterval(char[] tasks, int n) {
        // frequencies of the tasks
      if ( tasks == null || tasks.length == 0)
          return 0;
      HashMap<Character, Integer> map = new HashMap();
      int maxFreq = 0;
      int maxFreqCount = 0;
      for (int i = 0; i < tasks.length; i++)
      {
          map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
      }
      
      for ( int val: map.values())
      {
          maxFreq = Math.max(maxFreq,val); 
      }
      for ( int val: map.values())
      {
          if (maxFreq == val)
              maxFreqCount++;
      }
    
      int partitions = maxFreq - 1;
      int empty = (n-(maxFreqCount-1)) * partitions;
      int available = tasks.length - (maxFreq * maxFreqCount);
      int idle = Math.max(0, empty - available) ;
      return tasks.length + idle;
    }
}
