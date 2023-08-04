class Solution(object):
    def leastInterval(self, tasks, n):
        """
        Find the least number of intervals to complete all tasks.

        Time complexity: O(N)
        Space complexity: O(1)

        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        taskFreqMap = {}  # Create a hashmap to store task frequencies.
        maxFreq = 0  # Initialize the maximum frequency of any task.
        maxCount = 0  # Initialize the count of tasks with maximum frequency.

        for task in tasks:
            if task in taskFreqMap:
                taskFreqMap[task] += 1
            else:
                taskFreqMap[task] = 1
            maxFreq = max(maxFreq, taskFreqMap[task])

        for task in taskFreqMap.keys():
            if taskFreqMap[task] == maxFreq:
                maxCount += 1

        # Calculate the number of partitions required.
        partitions = maxFreq - 1
        # Calculate available time slots.
        availableSlots = partitions * (n - (maxCount - 1))
        # Calculate pending tasks.
        pendingTasks = len(tasks) - (maxFreq * maxCount)
        # Calculate idle time.
        idleTime = max(0, availableSlots - pendingTasks)

        return len(tasks) + idleTime  # Return the total intervals required.
