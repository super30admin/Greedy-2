class Solution {
    //Time Complexity:O(n)
    //Space Complexity:O(1)
    public int leastInterval(char[] tasks, int n) {
       if (tasks == null || tasks.length ==0) 
      return 0;

      HashMap<Character, Integer> map = new HashMap<>();
      int maxFreq =0;
      int maxCount =0;

      for (int i= 0;i < tasks.length;i++){
        char c= tasks[i];
        map.put (c, map.getOrDefault (c,0)+1);
        maxFreq = Math.max (maxFreq, map.get(c));
      }

      for (char key : map.keySet()){
        if (map.get(key) == maxFreq)
        maxCount++;
      }

      int partition = maxFreq -1;
      int empty = partition * (n - (maxCount -1));
      int pending = tasks.length - (maxCount * maxFreq);
      int idle = Math.max(0, empty -pending);
      return tasks.length + idle;
    }
}
