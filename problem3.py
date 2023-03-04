#time O(N)
#space O(N)
class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        d={}
        for i in S:
            d[i]= len(S)- S[::-1].index(i)-1
        print(d)
        i,j=0,0
        ans=[]
        res=0
        for k,c in enumerate(S):
            res=max(res,d[c])
            if k==res:
                ans.append(k+1-i)
                i=k+1
        return ans
                
            
            
        