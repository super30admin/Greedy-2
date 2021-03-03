/*
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        if tasks is None or len(tasks) == 0:
            return 0
        
        maxfreq = 0
        max_count_with_same_freq = 0
        mapping = dict()
        for t in tasks:
            mapping[t] = mapping.get(t, 0) + 1
            maxfreq = max(maxfreq, mapping[t])
        
        for key,val in mapping.items():
            if val == maxfreq:
                max_count_with_same_freq += 1
        
        partition = maxfreq - 1
        empty_slots = partition * (n-max_count_with_same_freq+1)
        pending_process = len(tasks) - max_count_with_same_freq*maxfreq
        idle_slot = max(0, empty_slots-pending_process)
        
        return idle_slot+len(tasks)
*/
// time - O(n)
// space - O(1)
// logic - first finding char with max freq because we want to separate it by giving partitions. If there are more than one char with same freq
// we group them and find partitions and then place remaining process in the empty partition slots
class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0)
            return 0;
        
        int maxFreq = 0, max_char = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char t:tasks){
            map.put(t, map.getOrDefault(t,0)+1);
            maxFreq = Math.max(maxFreq, map.get(t));
        }
        
        for (char key:map.keySet()){
            if (map.get(key) == maxFreq)
                max_char++;
        }
        
        int partitions = maxFreq - 1;
        int empty_slots = partitions * (n-max_char+1);
        int pending = tasks.length - maxFreq*max_char;
        int idle = Math.max(0, empty_slots - pending);
        
        return tasks.length + idle;
    }
}