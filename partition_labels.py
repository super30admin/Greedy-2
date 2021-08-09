class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        """
        TC:O(n)
        SC:O(26) =O(1), map will be having maximum 26 letter 
        """
        mapp={}
        for i,s in enumerate(S):
            mapp[s]=i
    
        print(mapp)
        
        start=0
        end=0
        res=[]
        for i, s in enumerate(S):
            ch=S[i]
            end= max(end, mapp[ch])
            if i==end:
                res.append(end-start+1)
                start=end+1
        return res
        