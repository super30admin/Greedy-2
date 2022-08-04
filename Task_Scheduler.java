class Solution {
    public int leastInterval(char[] task, int n) {
        int[] alpha = new int[26];
        Arrays.fill(alpha, 0);
        for (int i = 0; i < task.length; i++) {
            alpha[task[i] - 'A'] = 1 + alpha[task[i] - 'A'];
        }
        Arrays.sort(alpha);
        int chunks = alpha[25] - 1;
        int idle = chunks * n;
        for (int i = 24; i >= 0; i--) {
            idle = idle - Math.min(chunks, alpha[i]);
        }
        if (idle < 0)
            return task.length;
        return task.length + idle;
    }
}