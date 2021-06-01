# Time Complexity: O(n)
# Space Complexity: O(1)
# Ran on Leetcode: Yes

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        if not len(tasks):
            return 0
        if n == 0:
            return len(tasks)
        m = len(tasks)
        dic = {}
        maxFreq = 0
        maxCount = 0
        for elem in tasks:
            if elem in dic:
                dic[elem] += 1
            else:
                dic[elem] = 1
            maxFreq = max(maxFreq, dic[elem])
        for value in dic.values():
            if value == maxFreq:
                maxCount += 1
        partition = maxFreq - 1
        empty = (n - (maxCount - 1)) * partition
        available = m - maxFreq * maxCount
        idle = max(0, empty - available)
        return m + idle