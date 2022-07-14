import java.util.HashMap;

//Time Complexity : O(N)
//Space COmplexity : O(1)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        //map to maintain frequencies
        HashMap<Character,Integer> map = new HashMap<>();
        int maxFreq = 0; int maxCount = 0;
        for(char c : tasks){
            int freq = map.getOrDefault(c,0);
            freq++;
            maxFreq = Math.max(maxFreq,freq);
            map.put(c,freq);
        }
        
        //count the number of same maxFreq
        for(char key : map.keySet()){
            if(map.get(key) == maxFreq){
                maxCount++;
            }
        }
        //finding idle with help of partition,available and pending 
        int partition = maxFreq-1;
        int available = partition * (n-(maxCount-1));
        int pending = tasks.length - (maxFreq*maxCount);
        int idle = Math.max(0,(available-pending));
        //returning array length + idle to add the idle slots remaining
        return tasks.length + idle;
    }
}