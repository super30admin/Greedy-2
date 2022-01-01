// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :No(Glassdoor question )
// Any problem you faced while coding this 

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int maxFreq = 0, maxCount = 0;
        
        for(char c: tasks){
            hashMap.put(c, hashMap.getOrDefault(c,0) + 1);
            maxFreq = Math.max(maxFreq, hashMap.get(c));
        }
        for(int val: hashMap.values()){
            if(val == maxFreq) maxCount +=1;
        }
        int partitions = maxFreq - 1;
        int pending = tasks.length - maxFreq * maxCount;
        int empty = partitions * (n- (maxCount-1));// we take maxCount-1 so as to remove the first one behind which we are putting n cool off time period.
        int idle = empty - pending;
        if(idle<0) idle = 0;
        
        return idle+tasks.length;
    }
}