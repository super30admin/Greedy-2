// This solutions uses a partitioning technique where we start with the characters that has maximum frequency
// We count the partitions possible with this count
// Within those partitions we calculate how many left over elements can be fit into them
// We then find the idle time or left over time over these partitions and add this up with the total given length to calculate effective minimum interval
class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap();
        int max = 0;
        for(char c:tasks) {
            map.put(c, map.getOrDefault(c,0)+1);
            max=Math.max(max,map.get(c));
        }

        int totalElements = 0;
        for(Map.Entry<Character, Integer> entry:map.entrySet()) {
            int val = entry.getValue();
            if(val==max) {
                totalElements++;
            } 
        }

        int totalPartitions = max - 1;
        int availableSlots = totalPartitions * (n-(totalElements-1));
        int elementsLeft = tasks.length-(totalElements*max);
        int idleSlots = 0;
        if(availableSlots-elementsLeft>0) {
            idleSlots = availableSlots-elementsLeft;
        }

        return tasks.length+idleSlots;
    }
}
