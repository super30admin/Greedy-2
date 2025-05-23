// Time complexity :O(n)
// Space Complexity :O(n)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] counter = new int[26]; 
        int maxFreq = 0;
        int maxCount = 0;
        for (char task : tasks) {
            counter[task - 'A']++;
            if (counter[task - 'A'] == maxFreq) {
                maxCount++;
            } else if (counter[task - 'A'] > maxFreq) {
                maxFreq = counter[task - 'A'];
                maxCount = 1;
            }
        }
        int partCount = maxFreq - 1;
        int emptySlots = (n - (maxCount - 1)) * partCount;
        int availableSlots = tasks.length - (maxFreq * maxCount);
        int idle = Math.max(0, emptySlots - availableSlots);
        return tasks.length + idle;
    }
}
