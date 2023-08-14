class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] frequencies = new int[26];

        for (int i = 0; i < tasks.length; i++) {

            char c = tasks[i];
            frequencies[c - 'A']++;

        }

        Arrays.sort(frequencies);

        int freq_task = frequencies[25] - 1;
        int idle_slots = freq_task * n;

        for (int i = frequencies.length - 2; i >= 0; i--) {

            idle_slots = idle_slots - Math.min(frequencies[i], freq_task);
            int result = 0;

        }

        if (idle_slots > 0) {
            return idle_slots + tasks.length;
        }

        else {
            return tasks.length;
        }
    }
}