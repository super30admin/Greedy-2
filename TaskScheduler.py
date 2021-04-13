# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using HashMap to get the maxFrequency of element i n tasks array
# Iterate over the HashMap and get the maxCount that is how many elements have same maxFreq
# Then get the partitons, empty, available, idle values
# Return length of tasks + idle


class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        if not tasks:
            return 0
        dict = {}

        maxFreq = 0
        maxCount = 0
        for i in range(len(tasks)):
            if tasks[i] not in dict:
                dict[tasks[i]] = 1
            else:
                dict[tasks[i]] += 1
                maxFreq = max(maxFreq, dict[tasks[i]])

        for key, val in dict.items():
            if val == maxFreq:
                maxCount += 1

        partitions = maxFreq - 1
        empty = (n - (maxCount - 1)) * partitions
        available = len(tasks) - maxFreq * maxCount
        idle = max(0, empty - available)
        return len(tasks) + idle