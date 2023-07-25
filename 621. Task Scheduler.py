#Time Complexity:O(n)
#Space Complexity:O(n)

class Solution(object):
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        if len(tasks)==0:
            return 0
        freq={}
        maxi=-9999999999
        for i in range(len(tasks)):
            freq[tasks[i]]=freq.get(tasks[i],0)+1
            maxi=max(maxi,freq.get(tasks[i]))
        partition=maxi-1
        maxCount=0
        for ele in freq:
            if freq.get(ele)==maxi:
                maxCount=maxCount+1
        totalSlots=partition*(n-(maxCount-1))
        pendingTask=len(tasks)-(maxi*maxCount)
        idleTime=max(0,totalSlots-pendingTask)
        return len(tasks)+idleTime
