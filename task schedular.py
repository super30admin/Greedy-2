"""
Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Explaination
We get most frequent taks, we allocate them in distance of n
AB_AB _AB
then we find the no of partitions, empty spots, pending values and idle spots


"""

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        if tasks == None or len(tasks)==0: return 
        hm = {}
        maxfreq, maxcount =0,0
        for i in tasks:
            if i in hm:
                hm[i] += 1
            else:
                hm[i] = 1
            maxfreq = max(maxfreq, hm[i])
        
        for i in hm:
            if hm[i] == maxfreq:
                maxcount += 1
        
        partition = maxfreq - 1
        emptySpots = partition * (n-maxcount+1)
        pendingValues = len(tasks) - maxfreq*maxcount 
        idle = max(0, emptySpots-pendingValues)
        
        return len(tasks) + idle
        
        
        