# S30 Problem #140 Task Schedular
#LeetCode #621 https://leetcode.com/problems/task-scheduler/description/

# Author : Akaash Trivedi
# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode :  Yes #
# Any problem you faced while coding this : No

# start from bottle neck task: maximum frequency element
# check fro partitions: max freq-1 m then available= partition * n (intervals); pending = size - max freq
# calculate the number of idle slots required between these high-frequency tasks. idle = available-pending
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        hashm = {}
        maxFreq = 0
        for task in tasks:
            hashm[task] = hashm.get(task, 0) + 1
            maxFreq = max(maxFreq, hashm[task])
        maxNum = 0 # number of elements with max frequency
        for task in hashm:
            if hashm[task] == maxFreq:
                maxNum += 1

        partition = maxFreq - 1 # number of partitions between two same max freq tasks
        available = partition * (n - (maxNum - 1)) # available slots between this max freq partitons
        pending = len(tasks) - (maxFreq * maxNum) # pending after alloting the max freq tasks
        idle = max(0, available - pending)
        return len(tasks) + idle