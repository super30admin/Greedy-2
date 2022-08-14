# Approach : Greedy
# TC: O(n)
# SC: O(n)
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        task_len = len(tasks)
        d = {}
        max_freq = max_count = 0
        for t in tasks:
            d[t] = d.get(t,0) + 1
            max_freq = max(max_freq, d[t])
        
        for i in d:
            if d[i] == max_freq:
                max_count += 1
        partitions = max_freq - 1
        available_slots = partitions * (n - (max_count - 1))
        pending_slots = task_len - (max_freq * max_count)
        idle = max(0, available_slots - pending_slots)
        
        return task_len + idle