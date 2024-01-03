// Time Complexity:  O(n)
// Space Complexity: O(n)

class Solution {

    public int leastInterval(char[] tasks, int n) {

        Map<Character, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;
        int maxCount = 0;

        // Update freqMap, get maxFreq
        for(char task : tasks) {
            int count = freqMap.getOrDefault(task, 0) + 1;
            freqMap.put(task, count);
            maxFreq = Math.max(maxFreq, count);
        }    

        // get number of characters having maxFreq
        for(int val : freqMap.values()) {
            if(val == maxFreq)
                maxCount++;
        }

        int partitions = maxFreq - 1;
        int available = partitions * (n-(maxCount-1));
        int pending = tasks.length - (maxFreq * maxCount);
        int idle = Math.max(0, available - pending);

        return tasks.length + idle;

    }

}


// ******************** Another Method ********************

// Time Complexity:  O(n)
// Space Complexity: O(1)

class Solution {

    public int leastInterval(char[] tasks, int n) {

        int[] freqArr = new int[128];
        int maxFreq = -1;
        int maxCount = 0;

        // Update freqArr
        for(char task : tasks)
            freqArr[task]++;

        // Update maxFreq, maxCount
        for(int i=0; i<freqArr.length; i++) {
            if(freqArr[i] != 0) {
                if(maxFreq == -1 || freqArr[i] > maxFreq) {
                    maxFreq = freqArr[i];
                    maxCount = 1;
                }
                else if(freqArr[i] == maxFreq) {
                    maxCount++;
                }
            }
        }

        return Math.max(tasks.length, (n+1)*(maxFreq-1) + maxCount);

    }

}
