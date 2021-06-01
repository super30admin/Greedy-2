//TimeComplexity : O(1). As the maximum characters possible in the input array is 26
//Space Complexity : O(1) as HashMap will store at max 26 characters
//Note: In brute force all the combinations should be looked into to find the final result. But in greedy, this is avoided by choosing 
the characters with maximum frequency and count later thus speeding up the process.
// Did this code successfully run on Leetcode :yes
// Your code here along with comments explaining your approach
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(tasks==null||tasks.length==0){
            return 0;
        }
        int maxFreq=0,maxCount=0;
        //use hash map to record the frequency of the characters
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<tasks.length;i++){
            char c = tasks[i];
            if(!map.containsKey(c)){
                map.put(c,0);
            }
            //if this char already exists increase its frequency
            int count = map.get(c);
            count++;
            //update it in the map
            map.put(c,count);
            //get the maximum frequency count
            maxFreq = Math.max(maxFreq,count);
        }
        //get the maximum count of characters that have maxFrequency
        for(int values : map.values()){
            if(values==maxFreq){
                maxCount++;
            }
        }
        //calculate the total number of partiotions based on the character with maximum frequency
        int partition = maxFreq - 1;
        //the num of empty slots is derived based on cool time, maxCount and partition
        int empty = (n - (maxCount - 1)) * partition;
        //the available characters to use is given by tasks length subtracted from so far occupied characters(i.e characters with max frequency)
        int available = tasks.length - maxCount * maxFreq;
        //number of slots not occupied. If empty-availbe leads to a negative value then there are no idle spots. Inorder to avoid that 0 is palced for comparission to get the correct final result
        int idle = Math.max(0, empty - available);
        
        return tasks.length + idle;
        
    }
}