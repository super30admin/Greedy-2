#TC O(N)
#SC O(1) hash map has N letters which will be <=26 alphabets so O(1)

class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        res=[]
        if not S:
            return res
        
        d={}
        for i in range(len(S)):
            d[S[i]]=i
        
        #print(d)
            
        start=0
        end=0 
        for i in range(len(S)):
            ch=S[i]
            end=max(end,d[ch])
            if(i==end):
                res.append(end-start+1)
                start=end+1
        return res
        