# Time Complexity : O(N) where N length of the string
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        hashmap = {}
        maxFreq = 0
        maxCount = 0
        for t in tasks:
            if t in hashmap:
                hashmap[t] += 1
            else:
                hashmap[t] = 1
            maxFreq = max(maxFreq,  hashmap[t])
            
        
        for v in hashmap.values():
            if v == maxFreq:
                maxCount += 1
        
        
        partitions = maxFreq - 1
        available = partitions * (n - (maxCount - 1))
        pending = len(tasks) - (maxFreq * maxCount)
        idle = max(0, available - pending)
        
        return len(tasks) + idle