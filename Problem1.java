// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// We get the maxfrequency to each tasks and also the number of tasks having the maximum frequency
//We then have to calculate the idle slots present by calculated available slots and pending tasks
//if other tasks either can fill up these idle slots or not based on the n value given , we return the total tasks present along with idle tasks as answer

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character,Integer> map = new HashMap<>();
        int maxFreq = 0;
        int maxFreqTask = 0;

        for(char ch: tasks){
            map.put(ch, map.getOrDefault(ch,0)+1);
            maxFreq= Math.max(maxFreq, map.get(ch));
        }

        //get the number of maximum tasks
        for(char key: map.keySet()){
            if(maxFreq == map.get(key)) maxFreqTask++;
        }

        int partitions = maxFreq - 1;
        int availableSlots = partitions * (n -(maxFreqTask -1));
        int pendingTasks = tasks.length - maxFreqTask*maxFreq;
        int idleSlots = Math.max(0, availableSlots - pendingTasks);

        return tasks.length + idleSlots;
        
    }
}
