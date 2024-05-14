# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
from typing import List, collections
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        maxfreq = 0
        mdict = collections.defaultdict(int)
        for task in tasks:
            mdict[task]+=1
            maxfreq = max(maxfreq, mdict[task])

        maxCount = 0
        for i,j in mdict.items():
            if j == maxfreq:
                maxCount += 1
        
        partitions = maxfreq-1
        available = partitions*(n-(maxCount-1))
        pending = len(tasks)-(maxCount*maxfreq)
        empty = available-pending
        return len(tasks) + max(0,empty)