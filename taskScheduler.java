//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this : no
class Solution {
    public int leastInterval(char[] tasks, int n) {
       
        
        HashMap<Character,Integer> map1 = new HashMap<>();
        int maxFrequency = 0;
        for(int i = 0; i < tasks.length; i ++){
            
            int count = map1.getOrDefault(tasks[i],0);
            count ++;
            maxFrequency = Math.max(maxFrequency,count);
                                          
            map1.put(tasks[i],map1.getOrDefault(tasks[i],0)+1);
            
        }
        int maxCount = 0;
                                          
        for(int val: map1.values()){
            
            
            if(val == maxFrequency){
                
                maxCount ++;
                
            }
            
        }
                                          
        int partition = maxFrequency - 1;
        int available = (n - (maxCount-1)) * partition;
        int pending = tasks.length - (maxFrequency*maxCount);
        int idle = Math.max(0,available-pending);
                                          
        return tasks.length + idle;
    }
}