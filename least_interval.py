class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        """
        TC:O(n)
        SC:O(1) since map will consist at max 26 letter from A to Z
        """
        
        d={}
        maxfreq=0
        
        # number of maxfreq elements 
        maxcount=0
        
        for i,t in enumerate(tasks):
            if t in d:
                d[t]+=1
                maxfreq=max(maxfreq,d[t])
            else:
                d[t]=1
            
        for key, val in d.items():
            if val==maxfreq:
                maxcount+=1
        
        partitions=maxfreq-1
        empty = partitions * (n-(maxcount-1))
        available = len(tasks) - (maxfreq*maxcount)
        idle=max(0, empty-available)
        return len(tasks)+idle
                
        