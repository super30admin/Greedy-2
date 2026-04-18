# Time Complexity : O(T + U) where T is total tasks and U is the number of unique tasks.
# Space Complexity : O(U) for storing task counts in the hashmap.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : We find the task(s) that occur the most and figure out how many such max-frequency tasks exist.
# Then we calculate the number of idle slots required between these high-frequency tasks.
# If other tasks can fill those slots, we do, otherwise, we add idle time to the total.

class Solution:
    def leastInterval(self, tasks, n):
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
