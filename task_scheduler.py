# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I get max frequency task and number of max frequency tasks, then I calculate the space occupied by the max freq elements, I then calculate the 
# idle spots and the available spots. If idle spots less than 0 then I return length of tasks else length of tasks + idle

from collections import Counter
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        if n == 0: return len(tasks)
        counter = Counter(tasks)
        max_freq = -1
        max_count = 0
        for count in counter.items():
            if count[1] > max_freq:
                max_freq = count[1]
                max_count = 1
            elif count[1] == max_freq:
                max_count+=1
                
        gaps = max_freq - 1
        empty_slots = (n - (max_count - 1)) * gaps
        available_slots = len(tasks) - (max_freq*max_count)
        idle = max(0, empty_slots-available_slots)
        return len(tasks) + idle
        
        
            
