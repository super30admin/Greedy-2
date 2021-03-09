# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        if not tasks:
            return None
        
        hm = {}
        maxFreq = 0
        maxCount = 0 
        
        for i in tasks:
            if i not in hm:
                hm[i] = 0
            count = hm[i]
            count += 1
            maxFreq = max(maxFreq, count)
            hm[i] = count
        
        for key,val in hm.items():
            if val == maxFreq:
                maxCount += 1
                
        part = maxFreq - 1
        empty = (n-(maxCount-1))*part
        avail = len(tasks)-maxFreq*maxCount
        idle = max(0, empty-avail)
        return len(tasks) + idle