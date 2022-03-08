"""
time: O(N)
space: O(N)
"""
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        last = {c: i for i, c in enumerate(s)}
        ans = []
        x=anch=0
        for i, j in enumerate(s):
            x = max(x,last[j])
            if i == x:
                ans.append(i - anch + 1)
                anch = i + 1
        return ans
            