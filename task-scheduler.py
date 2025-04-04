# Time O(n)
# Space O(1)
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        m = len(tasks)
        fmap = defaultdict(int) # O(1) space 26 chars
        maxf = 0
        for task in tasks:
            fmap[task] += 1
            maxf = max(maxf, fmap[task])
        maxFreqTasks = 0
        for key in fmap:
            if fmap[key] == maxf:
                maxFreqTasks += 1
        
        partitions = maxf - 1
        available = partitions * (n - (maxFreqTasks - 1)) 
        pending = m - (maxf * maxFreqTasks)
        idle = max(0, available - pending)
        return m + idle

