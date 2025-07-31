// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public List<Integer> partitionLabels(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        int[] lastposition = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastposition[s.charAt(i) - 'a'] = i;
        }
        int start = 0;
        int end = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastposition[s.charAt(i) - 'a']);
            if (i == end) {
                int length = end - start + 1;
                result.add(length);
                start = i + 1;
            }
        }

        return result;

    }
}
//

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // Sort people:
        // 1. By height in descending order (taller people first).
        // 2. If heights are the same, sort by k in ascending order.
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0]; // Descending height
            } else {
                return a[1] - b[1]; // Ascending k
            }
        });

        List<int[]> result = new LinkedList<>();

        // Iterate through the sorted people and insert them into the result list
        // at the index specified by their k value.
        for (int[] p : people) {
            // p[1] is the k value, which is the correct insertion index.
            result.add(p[1], p);
        }

        // Convert the list back to a 2D array to return.
        return result.toArray(new int[people.length][]);
    }
}

//
class Solution {
    public int leastInterval(char[] tasks, int n) {
        // --- Step 1: Count Frequencies (Using a HashMap) ---
        Map<Character, Integer> freq = new HashMap<>();
        for (char task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }
        // --- Step 2: Find the frequency of the most common task ---
        int maxfreq = 0;
        for (int freqs : freq.values()) {
            maxfreq = Math.max(maxfreq, freqs);
        }
        // step-3: count how many same tasks have same maxfreq
        int maxfreqcount = 0;
        for (int freqs : freq.values()) {
            if (freqs == maxfreq) {
                maxfreqcount++;
            }
        }
        // step4-time cal
        int partitions = maxfreq - 1;
        int partitionlength = n + 1;
        int timeforfullpartitions = partitions * partitionlength;
        int totaltime = timeforfullpartitions + maxfreqcount;

        // step-5 handle no idle case
        return Math.max(tasks.length, totaltime);

    }
}
