# Time Complexity : O()
# Space Complexity : O()
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# arrange the maximum frequency tasks and count then add idle and len of array
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        hmap = {}
        
        maxFreq = 0
        maxCount = 0
        for i in tasks:
            cnt = 0
            if i in hmap:
                cnt = hmap[i]
            cnt += 1
            maxFreq = max(maxFreq, cnt)
            hmap[i] = cnt
        
        for key in hmap:
            if hmap[key] == maxFreq:
                maxCount += 1
        
        part = maxFreq - 1
        avai = part * (n-(maxCount - 1))
        pend = len(tasks) - (maxCount * maxFreq)
        idle = max(0,avai - pend)
        
        return idle + len(tasks)
            
                
        