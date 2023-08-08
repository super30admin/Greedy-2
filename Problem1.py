'''
Problem:  Task Scheduler
Time Complexity: O(n), where n is given elements
Space Complexity: O(1)
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        created a frequency map
        then calculated partitions, pending tasks, available tasks and idle
        return total tasks and idle slots    
'''

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        dicts = Counter(tasks)
        maxfreq = 0
        maxcount = 0
        for key, val in dicts.items():
            maxfreq = max(maxfreq, val)

        for key, val in dicts.items():
            if val == maxfreq:
                maxcount+=1

        partitions = maxfreq - 1
        available = partitions * (n - (maxcount - 1))
        pending = len(tasks) - maxfreq * maxcount
        idle = max(0, available - pending)

        return len(tasks) + idle
