import java.util.*;

class Solution {

    /**
    Time Complexity : O(N)
    Explanation:
    We count task frequencies once and then scan the frequency map.

    Space Complexity : O(1)
    Explanation:
    HashMap stores at most 26 uppercase English letters.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially struggled to calculate idle slots correctly.
    Fixed it by using the most frequent task as the base structure:
        - partitions = maxfreq - 1
        - available idle slots depend on cooldown n
        - pending tasks fill those idle slots
    Also handled multiple tasks having the same maximum frequency.
    */

    public int leastInterval(char[] tasks, int n) {

        HashMap<Character, Integer> map = new HashMap<>();

        int l = tasks.length;
        int maxfreq = 0;
        int noofmaxfreq = 0;

        // Count task frequency
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
            maxfreq = Math.max(maxfreq, map.get(task));
        }

        // Count how many tasks have max frequency
        for (char task : map.keySet()) {
            if (map.get(task) == maxfreq) {
                noofmaxfreq++;
            }
        }

        int partitions = maxfreq - 1;
        int available = partitions * (n - (noofmaxfreq - 1));
        int pending = l - (noofmaxfreq * maxfreq);
        int empty = Math.max(0, available - pending);

        return l + empty;
    }
}