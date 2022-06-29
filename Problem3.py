#Time Complexity : O(N)
#Space Complexity : O(1)
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        dic = {}
        for i in range(len(s)):
            dic[s[i]] = i
        res= []
        start = 0
        end = 0
        for i in range(len(s)):
            end = max(end , dic[s[i]])
            if i == end:
                res.append(end - start + 1)
                start = i+1 
            
        return res
            