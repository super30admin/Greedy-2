class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        hmap={}
        tot=len(tasks)
        maxFreq=0
        count=0
        for i in tasks:
            if i not in hmap:
                hmap[i]=0
            
            hmap[i]+=1
            if hmap[i]>maxFreq:
                maxFreq=hmap[i]
                count=1
            
            elif hmap[i]==maxFreq:
                count+=1
        

        create=(n+1)*(maxFreq-1)+count

        return max(tot, create)
