//TC : O(N) -- Traversing tasks ARRAY in linear time for calculating maxFreq and characters with maxFreq.
     
//SC : O(1)       

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        int maxFreq = 0; // Max freq of characters
        int maxChars = 0; // Character with max frew.
        for(char ch : tasks){
            int val = map.getOrDefault(ch, 0);
            val++;
            maxFreq = Math.max(maxFreq, val);
            map.put(ch, val);
        }
        
        
        for(char ch : map.keySet()){
            if(map.get(ch) == maxFreq)  maxChars++;
        }
        
        int parts =  maxFreq - 1;
        int available_slots = parts * (n - (maxChars - 1));
        int pending_tasks = tasks.length - (maxFreq * maxChars);
        
        int idle = Math.max(0, available_slots - pending_tasks );
        
        
        return tasks.length + idle;
    }
}