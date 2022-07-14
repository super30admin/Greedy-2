'''
time complexity: O(n)
space complexity: O(1)
'''
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        ct = {}
        for i in range(len(s)):
            ct[s[i]] = i
            
        start = 0
        end = 0
        res = []
        for i in range(len(s)):
            end = max(end,ct[s[i]])
            if end == i:
                res.append(end-start+1)
                start = i+1
        return res