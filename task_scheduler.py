# Time Complexity: O(n)
# Space Complexity:O(1)
from collections import defaultdict


class Solution:
    def leastInterval(self, tasks, n):
        m = len(tasks)
        if m == 0:
            return 0
        freqmap = defaultdict()

        for i in range(m):
            t = tasks[i]
            if t in freqmap:
                freqmap[t] += 1
            else:
                freqmap[t] = 1

        maxfreq = max(freqmap.values())
        maxCount = 0

        for v in freqmap.values():
            if maxfreq == v:
                maxCount += 1

        partition = maxfreq - 1

        available = partition * (n - (maxCount - 1))

        pending = m - (maxfreq * maxCount)

        pidle = available - pending
        idle = max(0, pidle)

        return m + idle

