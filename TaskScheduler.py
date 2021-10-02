"""
Time Complexity : O(n) where n is the total number of tasks 
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        if len(tasks) == 0:
            return 0
        maxi = 0
        maxCount = 0
        hashMap = {}
        # Hashmap to store frequencies of the tasks
        for i in tasks:
            if i in hashMap:
                hashMap[i] += 1
            else:
                hashMap[i] = 1
            maxi = max(maxi, hashMap[i])
        # Caluclate the max frequeny task
        for i in hashMap.keys():
            if maxi == hashMap[i]:
                maxCount += 1
        partitions = maxi - 1
        available = partitions * (n - maxCount + 1)
        pending = len(tasks) - (maxi * maxCount)
        idle = max(0, available - pending)
        return len(tasks) + idle
        