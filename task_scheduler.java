//TimeComplexity:O(N)
//SpaceComplexity:O(N)

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int maxFrequency = 0;
        int numberofMaxFrequency=0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i =0; i<tasks.length;i++) {
            char ch = tasks[i];
            if(!map.containsKey(ch)) {
                map.put(ch,0);
            }
            map.put(ch, map.get(ch)+1);
            maxFrequency = Math.max(maxFrequency,map.get(ch));
        }

        for (char  frequency : map.keySet()) {
            if (map.get(frequency) == maxFrequency) {
                numberofMaxFrequency = numberofMaxFrequency+1;
            }
        }

        int partitions = maxFrequency -1;
        int empty_slots = partitions * (n -(numberofMaxFrequency - 1));
        int pending = tasks.length - (maxFrequency * numberofMaxFrequency);
        int idle = Math.max(0,empty_slots-pending);
        return tasks.length + idle;
    }
}