#Time Complexity : O(n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes


class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        #get all the counts of tasks
        maxFrequencies = collections.Counter(tasks)

        maxFreq = max(maxFrequencies.items(), key=operator.itemgetter(1))[1]
        maxCount = 0
        for k, v in maxFrequencies.items():
            if v == maxFreq:
                maxCount += 1

        partitions = maxFreq - 1
        emptySpots = partitions * (n-maxCount+1)
        pendingTasks = len(tasks) - (maxFreq*maxCount)
        idleSpots = max(0, emptySpots-pendingTasks)

        return (len(tasks) + idleSpots)
