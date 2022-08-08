""""// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""

class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        result = []
        d = {}
        if s == None or len(s) == 0:
            return result
        for i in range(len(s)):
            c = s[i]
            d[c] = i
        start = 0
        end = 0
        for i in range(len(s)):
            c = s[i]
            end = max(end, d[c])
            if i == end:
                result.append(end - start + 1)
                start = i + 1
        return result



