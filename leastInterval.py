#TC O(N)
#SC O(1)
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        if not tasks:
            return []
        maxCount=0
        d=collections.Counter(tasks)
        maxFreq=0
        for elem in d:
            maxFreq=max(maxFreq,d[elem])
        #print(maxFreq)
        maxCount=0
        for ch in d.keys():
            if d[ch]==maxFreq:
                maxCount+=1
        partition=maxFreq-1
        emptyspot=partition*(n-maxCount+1)
        pending=len(tasks)-maxFreq*maxCount
        idle=max(0,emptyspot-pending) #emp-pen can go -ve
        return len(tasks)+idle
        
        
            
            
            
            
        