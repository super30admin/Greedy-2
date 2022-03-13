'''
TC: O(n)
SC: O(n)
'''
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        nlen = len(tasks)
        if not nlen:
            return 0
        
        hmap = dict()
        mfreq = float("-inf")
        mc = 0
        
        for t in tasks:
            hmap[t] = hmap.get(t, 0) + 1
            mfreq = max(mfreq, hmap[t])
        
        for i in hmap:
            if hmap[i] == mfreq:
                mc += 1
        
        partitions = mfreq - 1
        available = partitions * (n - (mc - 1))
        pending = nlen - (mfreq * mc)
        idle = max(0, available - pending)
        
        return nlen + idle
        
        
            