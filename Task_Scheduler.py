# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using HashMap to get the maxFrequency of element in tasks array
# Iterate over the HashMap and get the maxCount that is how many elements have same maxFreq
# Then get the partitons, available, pending, empty values
# Return length of tasks + empty


class Solution:
    def leastInterval(self, tasks: list[str], n: int) -> int:
        taskdict = {}
        maxFreq = 0
        maxCount = 0
        for i in range(len(tasks)):
            if tasks[i] not in taskdict:
                taskdict[tasks[i]] = 1
            else:
                taskdict[tasks[i]] += 1
            maxFreq = max(maxFreq, taskdict[tasks[i]])
        for key in taskdict:
            if taskdict[key] == maxFreq:
                maxCount += 1
        partitions = maxFreq - 1
        available = (n - (maxCount-1)) * partitions
        pending = len(tasks) - (maxFreq * maxCount)
        empty = max(0, available - pending)
        return len(tasks) + empty



        
