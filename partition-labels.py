# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        n=len(s)
        freq={}
        for i in range(n):
            freq[s[i]]=i
        i=0
        start=0
        end=0
        res=[]
        while i<len(s):
            end=max(freq[s[i]],end)
            if i==end:
                res.append(end-start+1)
                start=i+1
            i+=1
        return res
