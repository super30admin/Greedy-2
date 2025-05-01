// In this problem, using a hashmap and storing the frquency of each task, arranging the task with max frequency first by putting
// n intervals between all it's occurences. If more than 1 task have max frquency, arranging them first as pairs. Then, calculating
// how many partitions we did, based on that partitions, calculating how many empty spaces we have. And then how many tasks are
// pending to be schedule. Then how many idle spaces left, adding it to the tasks.length will give us the answer.

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Base Case
        if (tasks == null || tasks.length == 0) {
            return 0;
        }
        // Frequency map with task as key and it's frequency as value
        HashMap<Character, Integer> map = new HashMap<>();
        // Declare maxFrequeny variable
        int maxFreq = 0;
        // Declare maxCount for storing count if there is more than 1 task with
        // maxFrequency
        int maxCount = 0;
        // Iterate over all tasks and count their frequency and put in map
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            // Keep track of maxFrequency
            maxFreq = Math.max(maxFreq, map.get(c));
        }
        // Iterate over map and check how many tasks having maxFreq and store it in
        // maxCount
        for (char key : map.keySet()) {
            if (map.get(key) == maxFreq) {
                maxCount++;
            }
        }
        // Eg. A,B,A,C,B,D,B,A ... A:3, B:3, C:1, D:1
        // maxFreq=3 and maxCount=2 since A and B both have maxFreq
        // Compute partitions, i.e. for n=2, place A and B in pairs
        // such as A B _ A B _ A B, so as you can see there are maxFreq-1 partitions i.e
        // 2
        int partitions = maxFreq - 1;
        // Calc how many empty spaces, 2*(2-(2-1))=2, as you can see above only 2 empty
        // spaces left
        int empty = partitions * (n - (maxCount - 1));
        // Calc pending tasks, we can C and D are pending to be scheduled, 8-(3*2)=2
        int pending = tasks.length - (maxFreq * maxCount);
        // Calc idle spaces left after scheduling c and d both, 2-2 = 0
        int idle = Math.max(0, empty - pending);
        // Therefore ans = 8+0= 8 .... A B C A B D A B
        return tasks.length + idle;
    }
}