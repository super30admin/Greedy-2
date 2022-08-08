""""// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""


class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:

        d = {}
        maxFreq = 0
        d = Counter(tasks)
        for i in d:
            maxFreq = max(maxFreq, d[i])

        maxCount = 0
        for i in d:
            if d[i] == maxFreq:
                maxCount += 1

        partition = maxFreq - 1
        availableSlots = partition * (n - (maxCount - 1))
        pendingTasks = len(tasks) - (maxFreq * maxCount)
        idleSlots = max(0, availableSlots - pendingTasks)

        return len(tasks) + idleSlots