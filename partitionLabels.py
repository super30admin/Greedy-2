# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NO


# Your code here along with comments explaining your approach

class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        res = []
        
        if not S:
            return res
        
        hm = {}
        for i in range(len(S)):
            c = S[i]
            hm[c] = i
            
        start = 0 
        end = 0
        for i in range(len(S)):
            c = S[i]
            end = max(end, hm[c])
            if i == end:
                res.append(end-start+1)
                start = i+1
        return res