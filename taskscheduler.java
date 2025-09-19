// Time Complexity: O(T + U) – build the frequency map in O(T) and scan distinct tasks U (for A–Z letters, U ≤ 26 ⇒ O(T)).
// Space Complexity: O(U) – hashmap of distinct tasks (for A–Z, O(1)).

// Count frequencies and track maxFreq and maxCount (how many tasks reach maxFreq).
// Compute partitions = maxFreq - 1; availableSlots = partitions * (n - (maxCount - 1)); pending = tasks.length - maxFreq * maxCount; idle = max(0, availableSlots - pending).
// Return tasks.length + idle (equivalently: max(tasks.length, (maxFreq - 1) * (n + 1) + maxCount)).

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int maxCount = 0;

        for(char c : tasks){
            map.put(c, map.getOrDefault(c, 0)+1);
            maxFreq = Math.max(maxFreq, map.get(c));
        }   

        for(char c: map.keySet()){
            if(map.get(c) == maxFreq){
                maxCount++;
            }
        }

        int partitions = maxFreq - 1;
        int availableSlots = partitions * (n - (maxCount - 1));
        int pending = tasks.length - (maxFreq * maxCount);
        int idle = Math.max(0, availableSlots - pending);

        return tasks.length + idle;
    }
}
