//Problem 139: Task Scheduler
// Time Complexity :O(tasks length)
// Space Complexity :O(1), constant because of 26 characters only

// Your code here along with comments explaining your approach
/*
  1) Make a frequency map and then sort it on the basis of freqency so that we can get max frequency along with that while assigning tasks we can make sure that we are satisfying the higher frequency tasks first, because higher frequency is the constraint

  2) Find number of partitions which is max frequency.
  3) Find Number of chunks/number of processes that can come between a partition.
  4) Then find avalableSpots which is chunks * n(which is cooldown period).
  5) Iterate from the last index-1, because we have already satisfied the last index, and just keep subltracting availableSpots with minimum of (chunks,current frequency).
  6) If avaialbleSpots is smaller than 0, then just return the tasks length, otherwise just return the avaialbleSpots + tasks length
  
  Eg: ['A','A','A','B','B','B'], n=2
      A_ _A_ _A => partitions->3 | chunks->3-1=>2 | availableSpots->2*2=>4, means we have to satisfy 4 available spots

*/


import java.util.*;
class Solution139 {
    public int leastInterval(char[] tasks, int n) {
        
        if(tasks==null || tasks.length==0) return 0;
        
        int[] freq = new int[26];
        //frequency map
        for(char ch : tasks){
            freq[ch-'A']++;
        }
        
        //Sorting the freq so that we can find the max frequency and then while iterating over the frequency map, we can statisfy those tasks with higher frequency
        //As freq contains only 26 charaters thus TC: 26log26 would be constant and i.e O(1)
        Arrays.sort(freq);//TC:O(1)
        
        int partitions = freq[25];//number of partitions would be max frequency
        int chunks     = partitions - 1;//group of slots between the partitions/distance between partition
        int availableSpots  = chunks*n;//available Spots or idleSpots, means number of spots to be filled
        
        for(int i=24;i>=0;i--){
            availableSpots -= Math.min(chunks,freq[i]);
        }
        
        
        return availableSpots<0 ? tasks.length : tasks.length+availableSpots;
    }
}