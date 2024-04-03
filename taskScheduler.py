"""
Time Complexity : O(n) where n is length of the tasks
Space Complexity : O(1) as hashMap can contain only maximum 26 letters

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

"""
from collections import defaultdict


class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        if len(tasks) == 0:
            return 0
        hashMap = defaultdict()
        maxFreq = float('-inf')
        maxCount = 0

        for task in tasks:
            if task not in hashMap:
                hashMap[task] = 0
            hashMap[task] += 1
            maxFreq = max(maxFreq, hashMap[task])

        for value in hashMap.values():
            if value == maxFreq:
                maxCount += 1

        partitions = maxFreq - 1
        availableSlots = partitions * (n - (maxCount - 1))
        pendingTasks = len(tasks) - (maxFreq*maxCount)
        emptySlots = max(0, availableSlots - pendingTasks)

        return len(tasks) + emptySlots


# Second Approach: Using Formula totalCpuCycles = (maxFreq-1) * (n+1)

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        if len(tasks) == 0:
            return 0
        hashMap = defaultdict()
        maxFreq = float('-inf')
        maxCount = 0

        for task in tasks:
            if task not in hashMap:
                hashMap[task] = 0
            hashMap[task] += 1
            maxFreq = max(maxFreq, hashMap[task])

        for value in hashMap.values():
            if value == maxFreq:
                maxCount += 1

        totalCpuCycles = (maxFreq-1) * (n+1)

        return max(len(tasks), totalCpuCycles + maxCount)
