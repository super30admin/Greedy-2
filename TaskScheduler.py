"""
TC: O(n)
SC: O(1)
"""

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        if tasks is None or len(tasks) == 0: return 0

        hmap = defaultdict(int)
        maxFreq = 0
        maxCount = 0

        taskslen = len(tasks)

        for i in range(len(tasks)):
            hmap[tasks[i]] += 1
            maxFreq = max(maxFreq, hmap.get(tasks[i]))
        for v in hmap.values():
            if v == maxFreq:
                maxCount += 1
        partitions = maxFreq - 1

        empty = partitions * (n - (maxCount - 1))

        pendingTasks = taskslen - (maxFreq * maxCount)

        idle = max(0, empty - pendingTasks)

        return taskslen + idle