# Approach : Greedy, find letters that have most freqeuncy and in the case there are more with same freq update and partition
# Time - O(N)
# Space - O(N)
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        if not tasks or len(tasks) == 0:
            return 0
        
        max_freq = 0
        max_count_with_same_freq = 0
        
        hashmap = dict()
        
        for t in tasks:
            hashmap[t] = hashmap.get(t, 0) + 1
            max_freq = max(max_freq, hashmap[t])
        
        # if they have same frequencies update to max_count_with_same_freq
        for key,val in hashmap.items():
            if val == max_freq:
                max_count_with_same_freq += 1
        
        partition = max_freq - 1

        empty_slots = partition * (n-max_count_with_same_freq+1)
        pending_process = len(tasks) - max_count_with_same_freq*max_freq
        idle_slot = max(0, empty_slots-pending_process)
        
        return idle_slot+len(tasks)