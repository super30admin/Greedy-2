//TC:O(n)
//SC: O(1)
//running on leetcode: no
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks==null || tasks.length==0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max=0;
        int maxCount=0;
        for(int i=0; i<tasks.length; i++){
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
            max = Math.max(max, map.get(tasks[i]));
        }
        for (Character key : map.keySet()){
            if(max == map.get(key));{
              maxCount++;  
            }
        }
    int partitions = max - 1;
    int available = partitions * (n - maxCount + 1);
    int pending = tasks.length - (max * maxCount);
    int idle = Math.max(0, available - pending);
    return tasks.length + idle;
}
}


