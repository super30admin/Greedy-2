# The leastInterval method calculates the minimum time required to complete tasks with a cooling interval `n`.

# Count the frequency of each task.
# Sort frequencies to identify the task with the highest frequency (`maxf`).
# Calculate the idle time slots needed between executions of the most frequent task.
# Reduce idle slots by placing other tasks, filling up to their available frequency.

# Return the sum of the task count and the remaining idle slots.

# TC: O(n + 26 log 26) - Counting tasks and sorting fixed-size frequencies.
# SC: O(1) - Constant space for the frequency array.


from typing import List


class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        count = [0] * 26
        for task in tasks:
            count[ord(task) - ord('A')] += 1
        
        count.sort()
        maxf = count[25]
        idle = (maxf - 1) * n

        for i in range(24, -1, -1):
            idle -= min(maxf - 1, count[i])
        return max(0, idle) + len(tasks)