# // Time Complexity :O(n)
# // Space Complexity :O(1),characters
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach


class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        hmap={}
        maxfreq=0
        for i in range(len(tasks)):
            if tasks[i] not in hmap.keys():
                hmap[tasks[i]]=0
            hmap[tasks[i]]+=1
            maxfreq=max(maxfreq,hmap[tasks[i]])
        print(maxfreq) 
        maxcount=0
        for i in hmap.keys():
            if hmap[i]==maxfreq:
                maxcount+=1
        partition=maxfreq-1
        empty=partition*(n-(maxcount-1))
        pending=len(tasks)-(maxfreq*maxcount)
        idle=max(0,empty-pending)
        return len(tasks)+idle
        
        
       
        