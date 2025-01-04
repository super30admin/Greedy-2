"""
store the last index of character and partition based on last index 
TC: O(n)
SP: O(1)
"""
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        last = {}
        for i, c in enumerate(s):
            last[c] = i
        start, end = 0, 0
        res = []
        for i, c in enumerate(s):
            end = max(end, last[c])
            if i == end:
                res.append(end - start + 1)
                start = i + 1
        return res
