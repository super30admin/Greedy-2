#Time Complexity :o(n) 
#Space Complexity :o(1)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no

class Solution(object):
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        if(tasks==None or len(tasks)==0):
            return 0
        
        hmap={}
        maxi=0
        for i in tasks:
            if(i not in hmap):
                hmap[i]=1
            else:
                hmap[i]+=1
            if(hmap[i]>maxi):
                maxi=hmap[i]
        maxfreq=maxi        
        maxfrecount=0
        for val in hmap.values():
            if(val==maxfreq):
                maxfrecount+=1
        
        partitions=maxfreq-1
        empty=(n-(maxfrecount-1))*partitions
        available=len(tasks)-(maxfreq*maxfrecount)
        Idle=max(0,empty-available)
        return Idle+len(tasks)