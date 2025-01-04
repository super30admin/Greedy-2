// Approach : Since we try to schedule max freq tasks first at every step we can use a freq map and max Heap.
// In each iteration a cycle of length n+1 is considered, so that we dont violate the cooling period (n+1). 
// As we iterate we pop the highest freq task from the max heap and reduce the freq in freqMap and add the remaining
// to a temporary array and we continue until the cycle is completed. After every cycle we reconstruct the heap with the remainder of the array.
// Time : O(Nlogk) // k is max of 26
// Space : O(1)
class Solution {
    class Task {
        int freq;
        char taskName;

        public Task(char taskName, int freq) {
            this.taskName = taskName;
            this.freq = freq;
        };
    }

    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        // Build a frwq Map that stores task with their frequency of occurrence
        for(int i=0;i<tasks.length;i++){
            freqMap.put(tasks[i],freqMap.getOrDefault(tasks[i],0)+1);
        }

        // Define Max Heap that stores Task Object with max Freq at the top
        PriorityQueue<Task> pq = new PriorityQueue<>((a,b)-> {
            return b.freq - a.freq;
        }); 

        // Fill the Heap with Max Freq Task
        for(char task: freqMap.keySet()){
            // create Task Object - name and freq
            pq.add(new Task(task,freqMap.get(task)));
        }
        int taskCount =0;
        StringBuilder path = new StringBuilder();
        while(!pq.isEmpty()){
            int cycle = n+1; // cycle length to avoid the cooldown idle period
            List<Task> store = new ArrayList<>();
            // Repeat cycles until the heap is empty
            while(cycle > 0 && !pq.isEmpty()){
                cycle--;
                Task currTask = pq.poll();
                path.append(currTask.taskName); // Processed task added to path
                currTask.freq--;
                if(currTask.freq > 0){
                    store.add(currTask);
                }  
                taskCount++;
            }
            // Reconstruct the heap after we finish the cycle and heap is empty
            for(Task task: store){
                pq.add(task);
            }
            
            // To print the actual schedule of the tasks
            while(cycle > 0 && !pq.isEmpty()){
                path.append("_");
                taskCount++; // to make n+1
                cycle--;
            }
        }
        System.out.println(path.toString());
        return taskCount;
    }
}

// Approach : Greedy
// Time : O(2N)
// Space : O(1)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int totalLength = tasks.length;
        int maxFreq = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < totalLength; i++) {
            freqMap.put(tasks[i], freqMap.getOrDefault(tasks[i], 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(tasks[i]));
        }
        // this tracks the count of characters with the max frequency because
        // there may be multiple characters with same frequency
        int maxCount = 0;
        for (char task : freqMap.keySet()) {
            if (freqMap.get(task).equals(maxFreq)) {
                maxCount++;
            }
        }

        int partitions = maxFreq - 1;
        int availableSlots = partitions * (n - (maxCount - 1));
        int pending = totalLength - (maxFreq * maxCount);
        int idle = Math.max(0, availableSlots - pending);
        return totalLength + idle;
    }
}