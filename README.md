# Greedy-2

## Problem1 Task Scheduler (https://leetcode.com/problems/task-scheduler/)
# Time Complexity = O(n)
# Space Complexity = O(n)
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        map={}
        maxfreq=0
        for i in tasks:
            if i not in map:
                map[i]=1
            else:
                map[i]+=1
            if map[i]>maxfreq:
                maxfreq=map[i]
        maxcount=0
        for i in map:
            if map[i]==maxfreq:
                maxcount+=1
        partitions=maxfreq-1
        available=partitions*(n-(maxcount-1))
        pending=len(tasks)-maxfreq*maxcount
        idle=max(0,available-pending)
        return len(tasks)+idle
    

## Problem2 Queue Reconstruction by Height (https://leetcode.com/problems/queue-reconstruction-by-height/)
# Time Complexity = O(n**2)
# Space Complexity = O(n)
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        
        people.sort(key = lambda x: (-x[0], x[1]))
        output = []
        for p in people:
            output.insert(p[1], p)
        return output

## Problem3 Partition Labels (https://leetcode.com/problems/partition-labels/)
# Time Complexity = O(n)
# Space Complexity = O(n)

class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        h={}
        result=[]
        start=0
        end=0
        for i in range(len(s)):
            h[s[i]]=i
        for i in range(len(s)):
            if h[s[i]]>end:
                end=h[s[i]]
            if i==end:
                result.append(end-start+1)
                start=i+1
                end=0
        return result
            
    
            
        

