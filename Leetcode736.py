# Time = O(n)
# Space = O(n) 
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        lastIndex = {}
        size  = 0 
        end = 0
        for i, c in enumerate(s):
            lastIndex[c] = i
        res = []
        for i, c in enumerate(s):
            size += 1
            end = max(end,lastIndex[c])

            if i == end:
                res.append(size)
                size = 0
        return res
