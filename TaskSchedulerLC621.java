class Solution {
    
    //here, these 3 approaches are greedy approaches, and in them, we are first taking the most frequent task and perform them first and calculate the idle time, and we take rest of the tasks and perform in the idle time, and reduce the idle time, we have less than zero idle time means that we can do these tasks in tasks.length time and there's no idle time and if we have more than zero idle time means, we have more than zero idle time to perform all these taks, so we are calculating the idle time

    //Approach 3
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    
    public int leastInterval(char[] tasks, int n) {
        
        Map<Character, Integer> map = new HashMap<>();          //to store the frequency of each tasks
        int maxCount = 0;
        int maxFreq = 0;

        for(char c: tasks){                                     //iterating through tasks and store their freq in map, and get the maximum freq of any tasks
            int tempCount = map.getOrDefault(c, 0);
            tempCount++;
            maxFreq = Math.max(maxFreq,  tempCount);
            map.put(c, tempCount); 
        }

        for(char key: map.keySet()){                        //getting the counts of maxFrequent tasks

            if(map.get(key) == maxFreq){
                maxCount++;
            }
        }

        int partition = maxFreq - 1;                        //partition means, we perform the frequent tasks, and their's cooling period beween same task, that's we call paritition
        int availableSlots = partition * (n - (maxCount - 1));          //calculate the availble slots 
        int pendingTaks = tasks.length - (maxCount * maxFreq);          //calculating the pending tasks
        int idle = Math.max(0, availableSlots - pendingTaks);           //perform that pending tasks in available slots, and check if we have idle time of not

        return tasks.length + idle;                         //returning the result
    
    }




    //Approach 2
    //Time Complexity: O(n)
    //Space Complexity: O(1)

    // public int leastInterval(char[] tasks, int n) {
        
    //     int[] arr = new int[26];                        //to store the freq of each task
        
    //     //here, we are storing the frequency of each task
    //     for(char ch : tasks){
    //         arr[ch-'A']++;
    //     }
        
    //     //sort the array, means that more frequent task will be at last
    //     Arrays.sort(arr);
        
    //     int maxVal = arr[25]-1;                 //getting the most frequent task's frequency -1, because we are placing the most frequent task first
        
    //     int idleTime = maxVal * n;              //we can't do same task continuously, so we calculating the idle slots between the most frequent task
        
    //     for(int i=24; i>=0; i--){
            
    //         idleTime -= Math.min(arr[i], maxVal);   //then we are getting one less frequent task, and doing that task in our idle time, so have to reduce the idleTime slots by their frequency

    //     }
        
    //     return idleTime>0 ? idleTime + tasks.length : tasks.length;     // at last we'll see if we have any extra idle time, if so, then we add to the task length or else just return the tasks length
           
    // }
    
    
    
    
    
    //Approach 1
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    

//     public int leastInterval(char[] tasks, int n) {
        
//         Map<Character, Integer> map = new HashMap<>();           //to store the frequency of each task
        
//         for(char c: tasks){
//             map.put(c, map.getOrDefault(c, 0)+1);
//         }
    
//         PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b)-> b-a);
//         maxHeap.addAll(map.values());                            //sorting the tasks by their frequency and add to the decending priority queue
        
//         int cycles = 0;                                          //counter for time needed to perform all tasks
        
//         while(!maxHeap.isEmpty()){                               //iterating till our maxHeap is empty
            
//             List<Integer> temp = new ArrayList<>();                 //making temp list

//             for(int i=0; i<n+1; i++){                            //iterating from 0 to n

//                 if(!maxHeap.isEmpty()){                          //check if maxHeap is empty or not
//                     temp.add(maxHeap.remove());                  //if not empty then, remove the priority task from heap and add it to the temp list
//                 }
//             }
            
//             for(int i: temp){                                    //iterating the temp list, means getting the most frequent n tasks at a time, and perform them, if the occurance of that task is more, then reduce their frequency by 1 as we already performed once, and add it to the heap
                
//                 if(--i > 0){
//                     maxHeap.add(i);
//                 }
//             }
//             cycles += maxHeap.isEmpty() ? temp.size() : n + 1;       //check if maxHeap is empty, if so, means that there's the last tasks that were performed then just add the list size to the counter, if not then it means that we performed n+1 tasks and others are still remainning, so just add n+1 to the counter
//         }
//         return cycles;
//     }
}
