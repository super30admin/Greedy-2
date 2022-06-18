class Solution {

    // Time Complexity : 0(n) where n is the length of the char array
// Space Complexity : 0(1) we don't conside space for hashmap because in any case it will hold only 26 alphabets
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0){
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();  //storing the no. of occurences of each element in tasks
        int empty = 0;  //to calculate the empty slots once partition is done
        int pendingTask = 0;    //to calculate the pending task once all the partition is done and free slots are assigned
        int idle = 0;   //if partitions are done and the tasks are assigned, but due to n, if there are empty slots, then this captures it
        int maxCount = 0;   //it stores how many character have occurences that is equal to maxfreq
        int maxFreq = 0;//storing the max count of a character based on which the partition is don
        for(int i = 0; i < tasks.length; i++){
            char c = tasks[i];
            map.put(c, map.getOrDefault(c, 0) + 1); //storing the no. of occurences of each character
            maxFreq = Math.max(maxFreq, map.get(c));    //getting the max occurence of a character in taks
        }
        for(char c: map.keySet()){  //iterating over key set to see how many character have max freq. Eg: 4A4B3C. Here A and B both have max frequency so max count will be 2
            if(maxFreq == map.get(c)){
                maxCount++;
            }
        }
        int partitions = maxFreq-1; //making the partitions based upon the max freq
        empty = partitions * (n - (maxCount - 1));
        pendingTask = tasks.length - (maxFreq * maxCount);
        idle = Math.max(0, empty-pendingTask);
        return idle + tasks.length; //returning the total of idle and length as it all the processes have to be processed, so tasks.length and if a prcess has to wait for next execution because of n, so I add idle as well to result
    }
}