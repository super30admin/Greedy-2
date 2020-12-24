#Time: O(n)
#SPace: o(1)
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        
        freq = {}
        maxfreq = 0
        for c in tasks:
            count = freq.get(c,0)
            freq[c] = count+1
            maxfreq = max(maxfreq,count+1)
        
        maxCount =0 
        for c in freq.keys():
            if freq[c] == maxfreq:
                maxCount+=1
        
        partition = maxfreq-1
        empty = partition*(n-maxCount+1)
        pending = len(tasks)-maxfreq*maxCount
        idle = max(0,empty-pending)
        return len(tasks)+idle
        
        
