class Solution(object):
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        #O(n)
        #O(26)
        #find maxfreq and see how many char have that maxfreq
        if not tasks:
            return 0
        mp={}
        maxfreq=0
        maxcount=0
        for c in tasks:
            newcount=mp.get(c,0)+1
            mp[c]=newcount
            maxfreq=max(maxfreq,newcount)
        for c in mp:
            if maxfreq==mp[c]:
                maxcount+=1
        
        partitions=maxfreq-1
        empty=partitions*(n-maxcount+1)
        pending=len(tasks)-maxcount*maxfreq
        idle=max(0,empty-pending)
        return len(tasks)+idle
        
        