#Time Complexity :O(n) 
#Space Complexity :O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        map={}
        maxFreq=0
        maxCount=0
        for t in tasks:
            if t not in map.keys():
                map[t]=0
            map[t]+=1
            maxFreq=max(maxFreq,map[t])
        
        for i in map.keys():
            if map[i]==maxFreq:
                maxCount+=1

        partitions=maxFreq-1
        available=(n-(maxCount-1))*partitions
        pending=len(tasks)-(maxFreq*maxCount)
        idle=max(0,available-pending)

        return len(tasks)+idle
        