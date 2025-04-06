# https://leetcode.com/problems/task-scheduler/

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        hm = defaultdict(int)

        for i in range(len(tasks)):
            hm[tasks[i]] += 1
        
        max_freq = 0
        for _,v in hm.items():
            max_freq = max(max_freq,v)
        
        max_count = 0
        for _,v in hm.items():
            if v == max_freq:
                max_count += 1
        
        empty_slots = (n - (max_count - 1)) * (max_freq - 1)
        available_slots = len(tasks) - (max_count * max_freq)
        idle = max(0,empty_slots - available_slots)

        return len(tasks) + idle

# TC: O(n)
# SC: O(n)


        