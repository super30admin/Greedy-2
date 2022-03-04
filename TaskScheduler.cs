//Time: O(n)
//Space: O(1) //only of max size 26
// https://leetcode.com/submissions/detail/653379234/
public class Solution {
    public int LeastInterval(char[] tasks, int n) {
        Dictionary<char, int> map = new Dictionary<char, int>();
        int maxFrequency = 0;
        int maxCount = 0;
        
        foreach(char c in tasks) {
            if(map.ContainsKey(c)) {
                map[c] = map[c] + 1;
            } else {
                map.Add(c, 1);
            }
            if(map[c] > maxFrequency) {
                maxFrequency = map[c];
            }
        }
        
        foreach(KeyValuePair<char, int> entry in map) {
            if(map[entry.Key] == maxFrequency) {
                maxCount++;
            }
        }
        
        int partitions = maxFrequency - 1;
        int availableSlots = partitions * (n - (maxCount - 1));
        int pendingTasks = tasks.Length - maxFrequency * maxCount;
        int idealSlotsAfterAllTasksExecuted = Math.Max(0, availableSlots - pendingTasks);
        return tasks.Length + idealSlotsAfterAllTasksExecuted;
    }
}