"""
Greedy approach -
TC: O(n)
SC: O(1) ==> since fixed number of elements
"""

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        if tasks is None or len(tasks) == 0: return 0

        hmap = defaultdict(int)
        maxFreq = 0
        maxCount = 0

        taskslen = len(tasks)

        # step 1: get maxFreq
        for i in range(len(tasks)):
            hmap[tasks[i]] += 1
            maxFreq = max(maxFreq, hmap.get(tasks[i]))
        # print("maxFreq: ",maxFreq)

        # get maxCount, i.e. numberof elements with same freq
        for v in hmap.values():
            if v == maxFreq:
                maxCount += 1
        # print("maxCount: ", maxCount)

        # get partitions
        # (-1 since partitions are always 1 less as we dont need a partition at the end of the string)
        partitions = maxFreq - 1

        # get empty slots
        empty = partitions * (n - (maxCount - 1))

        # get pendingTasks
        pendingTasks = taskslen - (maxFreq * maxCount)

        # get idle slots
        idle = max(0, empty - pendingTasks)

        return taskslen + idle