//TC: O(m)
//SC: O(1)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Count the frequency of each task
        int[] frequencies = new int[26];  // There are only 26 possible tasks (A to Z)
        for (char task : tasks) {
            frequencies[task - 'A']++;
        }
        
        // Step 2: Sort the frequencies
        Arrays.sort(frequencies);
        
        // Step 3: Get the maximum frequency
        int maxFreq = frequencies[25];  // The highest frequency task
        
        // Step 4: Calculate the number of idle slots
        int idleSlots = (maxFreq - 1) * n;  // Number of idle slots between maxFreq tasks
        
        // Step 5: Fill the idle slots with remaining tasks
        for (int i = 24; i >= 0; i--) {
            idleSlots -= Math.min(frequencies[i], maxFreq - 1);  // Fill idle slots with tasks
        }
        
        // Step 6: If there are no idle slots left, we don't need to add idle time
        idleSlots = Math.max(0, idleSlots);
        
        // Step 7: Return the total time needed: either tasks.length or tasks.length + idleSlots
        return tasks.length + idleSlots;
    }
}
