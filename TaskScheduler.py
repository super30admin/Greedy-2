'''
TC: O(n) - for iterating through the tasks to get the maxFreq and maxCount
SC: O(1) - max elements in the dictionary can only be 26 characters
'''
import collections
from typing import List

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
s = Solution()
print(s.leastInterval(["A","A","B","A","B","A","C","B","D","E"],2))
print(s.leastInterval(["A","C","A","B","D","B"],1))
print(s.leastInterval(["A","A","A","B","B","B"],3))
print(s.leastInterval(["A","A","A","B","B","B"],2))