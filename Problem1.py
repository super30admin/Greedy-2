#time complexity o(n)
#space complexity o(1)
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        hmap = defaultdict(int)
        maxFreq = 0
        for task in tasks:
            hmap[task] += 1
            maxFreq = max(maxFreq,hmap[task])
        
        maxCount = 0
        for key in hmap:
            if hmap[key] == maxFreq:
                maxCount += 1
            
        partitions = maxFreq - 1
        available = partitions *(n-(maxCount -1))
        pending = len(tasks) - (maxCount * maxFreq)
        idle = max(0, available-pending)
        return len(tasks) + idle
        
        