// Time, Space - O(N), O(1)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        if(tasks == null || tasks.length == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int maxChar = tasks[0], max = 0;
        for(int i=0;i<tasks.length;i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
            if(map.get(tasks[i]) > max) {
                maxChar = tasks[i];
                max = map.get(tasks[i]);
            }
        }
        int maxCount = 0;
        for(char c : map.keySet()) {
            if(max == map.get(c)) {
                maxCount++;
            }
        }
        
        int partitions = max - 1;
        int emptySlots = partitions * (n - maxCount + 1);
        int pending = tasks.length - (maxCount * max);
        
        int idle = Math.max(0, emptySlots - pending);
        
        return tasks.length + idle;
        
        
    }
}
