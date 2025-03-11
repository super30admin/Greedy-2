// TC: O(n) as all the characters in array are traversed
// SC: O(26)/ O(1) as the tasks contains only English capital letters which won't exceed 26. Hence O(1) 

// Runs successfully on Leetcode.
// Sir discussed the formula to get the least interval, my approach is also based on the 
// formula but different approach. My approach is the max freq from the given input string, 
// later on this maxFreq value is checked how many times it is repeating.
// My formular for least interval is max between s.length and (maxFreq - 1) * (n + 1) + maxCount.
public class TaskScheduler {
    public static void main(String[] args) {
        System.out.println(leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 2)); // 8
        System.out.println(leastInterval(new char[] { 'A', 'C', 'A', 'B', 'D', 'B' }, 1)); // 6
        System.out.println(leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 3)); // 10
    }

    public static int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxFreq = 0;
        for (char s : tasks) {
            freq[s - 'A']++;
        }
        for (int i : freq) {
            maxFreq = Math.max(maxFreq, i);
        }
        int maxCount = 0;
        for (int i : freq) {
            if (i == maxFreq)
                maxCount++;
        }
        return Math.max(tasks.length, (maxFreq - 1) * (n + 1) + maxCount);
    }
}
