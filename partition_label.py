# Time Complexity: O(n)
# Space Complexity: O(1)
# Ran on Leetcode: Yes

class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        res = []
        if not len(s):
            return res
        dic = {}
        for i in range(len(s)):
            dic[s[i]] = i
        start = 0
        end = 0
        for i in range(len(s)):
            end = max(dic[s[i]],end)
            if end == i:
                res.append(end - start + 1)
                start = i + 1
        return res
        