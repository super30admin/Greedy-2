#As taught in class using greeedy technique to solve this problem
#Time complexity: O(n)
#Space complexity: O(1)
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        map = dict()
        maxFreq = 0
        cnt = 0
        for c in tasks:
            if c in map:
                cnt = map[c]
            else:
                map[c] = 0
            map[c] = cnt+1
            maxFreq = max(maxFreq,cnt+1)
        maxCount=0            
        for c in map:
            if map[c] == maxFreq:
                maxCount += 1
        partitions = maxFreq - 1
        empty = partitions*(n-maxCount+1)
        pending = len(tasks) - maxFreq*maxCount
        idle = max(0,empty-pending)
        return len(tasks)+idle