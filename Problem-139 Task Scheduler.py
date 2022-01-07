# 621. Task Scheduler
# https://leetcode.com/problems/task-scheduler/

# Time Complexity: O(n)
# Space Complexity: O(1) [only 26 letters possible so O(26)]

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        freq_hashmap = dict()
        max_count = 0
        
        for i in tasks:
            if i in freq_hashmap:
                freq_hashmap[i] += 1
            else:
                freq_hashmap[i] = 1
            
            max_count = max(max_count, freq_hashmap[i])