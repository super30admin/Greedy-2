# Time Complexity :O(N)
# Space Complexity :O(N)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach


class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        h={}
        for i in tasks:
            h[i]=h.get(i,0)+1
        l=len(tasks)
        m=max(h.values())
        c=0
        for i in h.values():
            if(i==m):
                c+=1
        partitions=m-1
        available_slots=(n-(c-1))*partitions
        pending=l-(m*c)
        idle=max(0,available_slots-pending)
        return l+idle