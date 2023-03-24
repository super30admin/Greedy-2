class Solution {
    public int leastInterval(char[] tasks, int n) {
        
		//Time: nlogn due to sort, we need to sort it according to frequencies because we need to take care of the abundant ones otherwise they will end up next to each other.
		//space: n, for the map
        int[] frequencies = new int[26];
        
        for(int i = 0; i < tasks.length; i++){
           
            char c = tasks[i];
            frequencies[c - 'A']++;
            
            
        }
        
        Arrays.sort(frequencies);
        
        //Since the array is sorted in ascending order, the largest element will be at the last index of the array.
        
        //Last occurence of frequent task is not counted
        int freq_task = frequencies[25] - 1;
        int idle_slots = freq_task * n;
        
        for(int i = frequencies.length - 2; i >=0; i--){
            
            //Keep on subtracting the values seen  at i from the idele slots.
            
            idle_slots = idle_slots - Math.min(frequencies[i], freq_task);
            int result  = 0;
            
        }
        
        if(idle_slots > 0){
                return idle_slots + tasks.length;
            }
            
            else{
                return tasks.length;
            }
    }
}