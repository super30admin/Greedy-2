#Time complexity: O(n)
#Space complexity: O(n)
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        dict1={}
        res=[]
        for i in range(len(s)):
            dict1[s[i]]=i
        start,end=0,0
        for j in range(len(s)):
            end=max(end,dict1[s[j]])
            if j==end:
                res.append(end-start+1)
                start=j+1
        return res