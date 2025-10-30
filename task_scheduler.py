class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        map = {}
        maxFreq = 0
        maxCount = 0

        for c in tasks:
            map[c] = map.get(c, 0) + 1
            maxFreq = max(maxFreq, map[c])

        for c in map:
            if map[c] == maxFreq:
                maxCount += 1

        partitions = maxFreq - 1
        availableSlots = partitions * (n - (maxCount - 1))
        pending = len(tasks) - (maxFreq * maxCount)
        idle = max(0, availableSlots - pending)

        return len(tasks) + idle
        