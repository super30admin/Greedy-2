// Time Complexity : O(n), where n is the number of characters in the array (exactly O(2n), O(n), to fill out the hashMap, O(n) to
                        //  find the character(s) with maximum frequecy)
// Space Complexity : O(1), constant space used (hashMap of maximum 26 entries)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//Three liner approach of your code in plain English
//Intuition ->  Think Greedy, that where to start from. The answer is the character(task) with the highest freqency. Because when you
                //place those characters their frequency times, seperated with n (cooling period). That will be the minimum number of
                //spots required (as you can place the rest characters in those idle spots , WHILE also can leave some idle spots)
                //So the problem here can be boiled down to finding the number of idle spots (result = total characters + idle spots)
//1. Create a hashMap of given characters and their respective frequency. Iterate over the hashmap to find the character(s), with
        //heighest frequency
//2. calculate the following,
        //1. partitions -> after placing the character(s) with highest frequency, how many partitions are created (maxFreq - 1)
        //2. Empty spots -> how many empty spots are there after placing the character(s) with highest frequency 
                //(partitions * n-maxCount +1)
        //3. pending tasks ->  after placing the character(s) with highest frequency, how many tasks are still remaining
                //(total tasks - maxFreq*maxCount)
        //4. idle spots -> after placing all the tasks w.r.t the tasks with the highest frequency, how many idle spots will still remain
                //(Math.max(Empty spots - pending tasks , 0))
//3. Result is the addition of total number of tasks and the idle spots

// Your code here along with comments explaining your approach

class Solution {
    public int leastInterval(char[] tasks, int n) {
        //create a hashMap to get the frequency of each character
        Map<Character, Integer> map = new HashMap<>();
        //fill the hashMap
        for(char c : tasks){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        //maximum frequency
        int maxFreq = 0;
        //count of characters with maximum frequency
        int maxCount = 0;
        //iterate over the hashMap to get the character(s) with highest frequency
        for(Integer count : map.values()){
            if(count > maxFreq){//a new character with high frequency
                maxFreq = count;
                maxCount = 1;
            }else if(count == maxFreq){//one more charcter with same high frequency
                maxCount++;
            }
        }
        
        //number of partitions
        int partitions = maxFreq-1;
        //number of Empty spots
        int empty = partitions * (n-maxCount+1);
        //number of pending tasks
        int pending = tasks.length - maxFreq*maxCount;
        //number of idle spots
        int idle = Math.max(empty - pending, 0);
        
        //result is the number of tasks plus the number of idle spots
        return tasks.length + idle;
    }
}