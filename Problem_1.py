"""
Problem : 1

Time Complexity : O(n)
Space Complexity : O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


"""

# Task Scheduler

class Solution(object):
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        hmap={}
        maxFreq=0
        for task in tasks:
            if task not in hmap:
                hmap[task]=0
            hmap[task]+=1
            maxFreq=max(maxFreq,hmap[task])
        maxCount=0
        for task in hmap:
            if hmap[task]==maxFreq:
                maxCount+=1
        partitions=maxFreq-1
        available=partitions*(n-maxCount+1)
        pending=len(tasks)-maxFreq*maxCount
        idle=max(0,available-pending)
        return idle+len(tasks)