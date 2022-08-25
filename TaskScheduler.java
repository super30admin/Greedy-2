// Time Complexity : O(n)
// Space Complexity : O(1) //map is max 26 chars
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int leastInterval(char[] tasks, int n) {

        //we already have the number of tasks, the problem reduces to finding the number of idle slots the CPU will need due to cooling period

        //create a char array to save frequency of each char in input
        int[] freqMap = new int[26];

        for(char c : tasks) {
            freqMap[c - 'A']++;
        }

        int maxFreq=0; //maximum freq in the map
        int maxCount=0; //number of chars with max freq in input

        for(int freq : freqMap) {

            if(freq > maxFreq) {
                maxFreq =  freq;
                maxCount = 1;
            }
            else if(freq == maxFreq)
                maxCount++;
        }

        //we schedule the maxFreq tasks first, with n slots in between, thus forming groups where other tasks can fit in
        int groups = maxFreq - 1;

        //slots available between these already scheduled tasks
        int availableSlots = groups * (n - (maxCount - 1));

        //total tasks - already scheduled tasks
        int pendingTasks = tasks.length - maxFreq*maxCount;

        //to prevent the subtraction from becoming 0
        int idleSlots = Math.max(0, availableSlots - pendingTasks);

        return tasks.length + idleSlots;
    }
}
