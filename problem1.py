#Time O(n), space O(1)

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        h={}
        maxfreq=0
        maxcount=0
        
        #Creating hashmap with frequencies to calculate maxfreq and max count 
        for i in tasks:
            if i not in h:
                h[i]=1
            else:
                h[i]+=1
                
            if h[i]>maxfreq:
                maxfreq=h[i]
                
        for i in h:
            if h[i]==maxfreq:
                maxcount+=1
     #Computations           
        p=maxfreq-1   
        available=p*(n-(maxcount-1))
        pending=len(tasks)-maxfreq*maxcount
        idle=max(0,available-pending)
        
        return len(tasks)+idle
        
