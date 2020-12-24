#Time: O(2N)
#Space: O(1)
class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        
        res=[]
        
        if S is None or len(S)==0:
            return res
        
        last = {c:i for i,c in enumerate(S)}
        
        maxi=0; size =1
        for i,c in enumerate(S):
            maxi = max(maxi,last[c])
            
            if i==maxi:
                res.append(size)
                size=1
            else:
                size+=1
        
        return res
            
