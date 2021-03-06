// Time Complexity : 0(n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        //count frequencies of all characters
        int[] frequencies = new int[26];
        for(int t : tasks){
            frequencies[t - 'A']++;
        }

        //finding the maximum frequency
        int f_max = 0;
        for(int f : frequencies){
            f_max = Math.max(f_max, f);
        }

        //finding how many characters have max frequency
        int maxCount = 0;
        for(int f : frequencies){
            if(f == f_max)
                maxCount++;
        }

        //total partitions would be 1 less than max frequency
        int partitions = f_max - 1;
        //calculate empty, available and idle
        int empty = (n - (maxCount -1)) * partitions;
        int available = tasks.length - f_max * maxCount;
        int idle = empty - available;
        //either length of tasks is greater or length of tasks + idle places
        return Math.max(tasks.length, tasks.length + idle);
    }
}