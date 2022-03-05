"""
Given a characters array tasks, representing the tasks a CPU needs to do, 
where each letter represents a different task. Tasks could be done in any order. 
Each task is done in one unit of time. For each unit of time, the CPU 
could complete either one task or just be idle.

However, there is a non-negative integer n that represents the cooldown period 
between two same tasks (the same letter in the array), that is that there must be 
at least n units of time between any two same tasks.

Return the least number of units of times that the CPU will take to finish 
all the given tasks.
"""

# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        mp = {}
        maxFreq = 0
        maxCount = 0
        count = 0
        
        for task in tasks:
            
            if task in mp.keys():
                mp[task] += 1
                
            else:
                mp[task] = 1
                
            maxFreq = max(maxFreq, mp[task])
            
        for i in mp.keys():
            if mp[i] == maxFreq:
                maxCount += 1
                
        part = empty = pending = idle = 0
        
        part = maxFreq-1
        empty = part * (n-(maxCount-1))
        pending = len(tasks) - (maxFreq * maxCount)
        idle = max(0, empty - pending)
        return len(tasks)+idle
        