#Time: O(n)
#Space: O(1)
#Program ran on leetcode successfully

class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        res = []
        lastOcc = {}
        for i in reversed(range(len(s))):
            if s[i] not in lastOcc:
                lastOcc[s[i]] = i
        
        start = 0
        end = -1
        
        for i in range(len(s)):
            if lastOcc.get(s[i]) > end:
                end = lastOcc.get(s[i])
            
            if i == end:
                res.append(end - start + 1)
                start = end + 1
        
        return res
            
        