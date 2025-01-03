// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Problem1 {
    //TC: O(2N)
    //SC :O(1)
    public int leastInterval(char[] tasks, int n) {
        int totalLength =  tasks.length;
        int maxFreq = 0;
        Map<Character,Integer> freqMap = new HashMap<>();
        for(int i=0;i<totalLength;i++){
            freqMap.put(tasks[i], freqMap.getOrDefault(tasks[i], 0)+1);
            maxFreq = Math.max(maxFreq, freqMap.get(tasks[i]));
        }
        //this tracks the count of characters with the max frequency because
        //there may be multiple characters with same frequency
        int maxCount = 0;
        for(char task : freqMap.keySet()){
            if(freqMap.get(task).equals(maxFreq)){
                maxCount++;
            }
        }

        int partitions = maxFreq - 1;
        int availableSlots = partitions * (n-(maxCount -1));
        int pending = totalLength - (maxFreq*maxCount );
        int idle  = Math.max(0,availableSlots - pending) ;
        return totalLength+idle;

    }
}

