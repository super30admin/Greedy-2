#time: O(n)
#space: O(1)

from collections import Counter
class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        start=0
        end=0
        endindex={}
        result=[]
        for i in range(len(S)):
            endindex[S[i]]=i
        
        for i in range(len(S)):
            end=max(endindex[S[i]],end)
            if(i==end):
                length=end-start+1
                result.append(length)
                start=end+1
        return result
            
        
        