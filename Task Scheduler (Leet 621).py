'''
Time: O(n)
Space: O(n)
'''

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        
        hm = dict()
        maxFreq = 0
        maxCount = 0
        for ch in tasks:
            if ch in hm:
                hm[ch] += 1
            else:
                hm[ch] = 1
            maxFreq = max(maxFreq,hm[ch])
        
        for k in hm:
            if hm[k] == maxFreq:
                maxCount += 1
        
        partitions = maxFreq - 1
        available = partitions * (n - (maxCount - 1))
        pending = len(tasks) - maxFreq * maxCount
        idle = max(0, available - pending)
        
        return len(tasks) + idle
            
        