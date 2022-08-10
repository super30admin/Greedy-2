# time complexity is o(n), where n is the size of the input
# space complexity is o(n), where n is the size of the input
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        taskLength = len(tasks)
        d = dict()
        maxfreq = 0
        maxCount = 0
        for t in tasks:
            if(t not in d):
                d[t] = 0
            d[t] += 1
            maxfreq = max(maxfreq, d[t])
        for i in d:
            if(d[i] == maxfreq):
                maxCount += 1
        
        partitions = maxfreq - 1
        availableSlots = partitions * (n - (maxCount - 1))
        pendingSlots = taskLength - (maxfreq * maxCount)
        idle = max(0, availableSlots - pendingSlots)
        
        return taskLength + idle
    
        
            
        