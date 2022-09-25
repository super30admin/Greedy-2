# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        task_length = len(tasks)
        d = {}
        max_freq = 0
        max_count = 0
        for t in tasks:
            d[t] = d.get(t,0) + 1
            max_freq = max(max_freq, d[t])
        
        for i in d:
            if d[i] == max_freq:
                max_count += 1
        partitions = max_freq - 1
        available_slots = partitions * (n - (max_count - 1))
        pending_slots = task_length - (max_freq * max_count)
        idle_time = max(0, available_slots - pending_slots)
        
        return task_length + idle_time