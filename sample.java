## Problem1 Task Scheduler (https://leetcode.com/problems/task-scheduler/)

// Time Complexity : 0(n) where n is the length of the tasks array. This is because we iterate over the tasks array once
// Space Complexity : 0(k) or 0(1) where k is the number of unique tasks in the array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int maxCount = 0;

        for (int i = 0; i < tasks.length; i++) {
            char c = tasks[i];
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(c));
        }

        for (char key : map.keySet()) {
            if (map.get(key) == maxFreq) {
                maxCount++;
            }
        }
        int partitions = maxFreq - 1;
        int totalSlots = partitions * (n - (maxCount - 1));
        int pendingTasks = tasks.length - (maxFreq * maxCount);
        int idle = Math.max(0, totalSlots - pendingTasks);

        return tasks.length + idle;
        
    }
}


## Problem2 Queue Reconstruction by Height (https://leetcode.com/problems/queue-reconstruction-by-height/)

// Time Complexity : 0(nlogn) + 0(n^2) 
// Space Complexity : 0(n)  because we create a list result to store the reconstructed queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) {
            return new int[][]{};
        }
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        List<int[]> result = new ArrayList<>();

        for (int[] person : people) {
            result.add(person[1], person);
        }
        return result.toArray(new int[0][]);       
    }
}


## Problem3 Partition Labels (https://leetcode.com/problems/partition-labels/)

// Time Complexity : 0(n)  
// Space Complexity : 0(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<Integer> partitionLabels(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        int n = s.length();
        int start = 0;
        int end = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, i);
        }

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            end = Math.max(end, map.get(c));
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}