'''
Time Complexity: O(n)
Space Complexity: O(1)

Approach: 
1. Create a frequency map to count the occurrences of each task.
2. Find the maximum frequency and the number of tasks that have this maximum frequency.
3. Calculate the number of partitions that can be formed with the maximum frequency.
4. Calculate the number of available slots in the partitions.
5. Calculate the number of pending tasks that need to be scheduled.
6. Calculate the number of idle slots needed to be filled.
7. Return the total number of intervals needed to schedule all tasks.
'''

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        freqMap = {}
        maxFreq = -1
        maxNum = 0

        for task in tasks:
            if task not in freqMap:
                freqMap[task] = 1
            else:
                freqMap[task] += 1
            maxFreq = max(maxFreq, freqMap[task])

        for task in freqMap:
            if freqMap[task] == maxFreq:
                maxNum += 1

        partitions = maxFreq - 1
        available = partitions * (n - (maxNum - 1))
        pending = len(tasks) - (maxNum * maxFreq)
        idle = max(0, available - pending)

        return len(tasks) + idle