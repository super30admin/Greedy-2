# TC: O(n)
# SC: O(26) at worst so O(1)
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        h = {}
        max_freq = 0
        max_freq_count = 0
        for i in range(len(tasks)):
            if tasks[i] not in h.keys():
                h[tasks[i]] = 0
            h[tasks[i]] += 1
            if h[tasks[i]] == max_freq:
                max_freq_count += 1
            if h[tasks[i]] > max_freq:
                max_freq = h[tasks[i]]
                max_freq_count = 1
        partitions = max_freq - 1
        available = partitions * (n-(max_freq_count-1))
        remaining = len(tasks) - (max_freq*max_freq_count)
        empty_slots = max(0,available-remaining)
        
        return len(tasks) + empty_slots
        
        
            
        
        