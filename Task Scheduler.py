#time: O(n)
#space: O(1)

from collections import Counter
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        count=Counter(tasks)
        maxcount=0
        samecount=0
        for i in count:
            maxcount=max(maxcount,count[i])
        
        for i in count:
            if(count[i]==maxcount):
                samecount+=1
        
        partitions = maxcount-1
        empty= (n-(samecount-1))*partitions
        availableSpace= len(tasks)-maxcount*samecount
        idle= max(0, empty-availableSpace)
        result=len(tasks) + idle
        return result
        
        