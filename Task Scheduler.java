// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach
// We will be using a Hashmap to store the frequency of each character. Then we will find the maximum frequency amongst all the characters. If there are more than one character with the maximum Frequency, 
// then we will keep a count of that as well. We will place these characters with maximum frequncies first, with a distance of n from each other. Then we will start placing the remaining elements from the array 
// in the new one. To find out how many least number of units the CPU will take, we need to first find the number of partitions done while placing the characters with maximum frequency. Then we need to find 
// total number of time units available between each max Frequency charachter. Then we will have to find the pending characters from the input string by subtracting characters with max frequency from the given input. 
// Finding pending characters and available time units will help us in finding the idle time units. The total time units required would be the length of the given array and the number of idle time units. 


class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        HashMap<Character,Integer> map=new HashMap<>();
        int maxFreq=0;
        for(char task:tasks)
        {
            map.put(task,map.getOrDefault(task,0)+1);
            maxFreq=Math.max(maxFreq,map.get(task));
        }

        int maxCount=0;
        for(char ch:map.keySet())
        {
            if(map.get(ch)==maxFreq)
            {
                maxCount++;
            }
        }

        int partitions=maxFreq-1;
        int available=(n-(maxCount-1)) * partitions;
        int pending=tasks.length-(maxCount*maxFreq);
        int idle=Math.max(0,available-pending);
        return tasks.length + idle;
    }
}