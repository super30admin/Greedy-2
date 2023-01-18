# Time Complexity : T(N), Where N is the number of elements in the tasks list 
# Space Complexity : O(N), Where N is the number of elements in the tasks list
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing Specific

from typing import List
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        N=len(tasks)
        #First let us calculate the frequency of all the tasks
        hashmap={}
        for i in tasks:
            if(i in hashmap):
                hashmap[i]+=1
            else:
                hashmap[i]=1
        
        #Second let us calculate the maxfreq, maxcount
        maxfreq=0
        maxcount=0
        for i in hashmap:
            if(hashmap[i]>maxfreq):
                maxfreq=hashmap[i]
        for i in hashmap:
            if(hashmap[i]==maxfreq):
                maxcount+=1
        
        #print(hashmap)
        #print(maxfreq)
        #print(maxcount)
        
        partitions=maxfreq-1
        emptyslots=(partitions*(n-(maxcount-1)))#This will give all the empty slots available after assigning maximum frquency value(s)
        remaingtasks=(N-(maxfreq*(maxcount)))#This will give the remaining elments in actual tasks after assigning maximum frequency value(s) 
        idletasks=max(0,emptyslots-remaingtasks)
        
        return N+idletasks