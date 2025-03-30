// Time Complexity : O(nlogn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (char key : map.keySet()) {
            pq.add(map.get(key));
        }

        Queue<int[]> q = new LinkedList<>();

        int t = 0;

        while (!pq.isEmpty() || !q.isEmpty()) {
            int freq;
            if (!pq.isEmpty()) {
                freq = pq.poll();
                if (freq > 1)
                    q.add(new int[] { freq - 1, t + n });
            }

            if (!q.isEmpty() && t == q.peek()[1]) {
                pq.add(q.peek()[0]);
                q.poll();
            }

            t++;
        }
        return t;
    }
}