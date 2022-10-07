//TC : O(n)
//SC : O(n)

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map = new HashMap<>();
        
        int maxFreq = -1;
        for(char c:tasks){
            map.put(c,map.getOrDefault(c,0)+1);
            maxFreq = Math.max(maxFreq,map.get(c));
        }   
        
        int maxFreqCnt = 0; //to handle mutiple task with max frequency
        for(char c:map.keySet())
            if(map.get(c) == maxFreq) maxFreqCnt++;
        
        int len = tasks.length;
        int partitions = maxFreq - 1;
        int availbleSlots = partitions * (n - (maxFreqCnt-1));
        int filledSlots = len -  (maxFreq*maxFreqCnt);
        
        //if we filled all the slots in between so 0
        int emptySlots = filledSlots < availbleSlots ? availbleSlots - filledSlots : 0;
        
        return len+emptySlots;
    }
}
