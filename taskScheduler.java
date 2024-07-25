import java.util.*;

class Solution {
    // Tc: O(n) Sc: O(n) ~ O(1) as n = 26
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0)
                pq.add(freq[i]);
        }

        int res = 0;

        while (!pq.isEmpty()) {
            int loop = n + 1;
            int cnt = 0;
            List<Integer> values = new ArrayList<>();
            while (loop > 0 && !pq.isEmpty()) {
                int curr = pq.poll();
                values.add(curr - 1);
                loop--;
                cnt++;
            }
            for (int value : values) {
                if (value > 0) {
                    pq.add(value);
                }
            }
            res += (pq.isEmpty() ? cnt : n + 1);
        }
        return res;
    }
}