//Time Complexity - O(n)
//Space Complexity - O(1)
class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int maxFrequency = 0;
        int maxCount = 0;

        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFrequency = Math.max(maxFrequency, map.get(c));
        }

        for(char key: map.keySet()){
            if(map.get(key) == maxFrequency){
                maxCount++;
            }
        }

        int partitions = maxFrequency - 1;
        int emptySlots = partitions * (n - (maxCount - 1));
        int pending = tasks.length - (maxFrequency * maxCount);
        int idle = Math.max(0, emptySlots - pending);

        return tasks.length + idle;
    }
}
