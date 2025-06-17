"""
TC - O(n)
SC - O(1)
"""
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        if s is None or len(s) == 0: return []

        hmap = {}
        start = 0
        end = 0

        rtnData = []

        n = len(s)

        for i in range(n):
            hmap[s[i]] = i

        for i in range(n):
            end = max(end, hmap[s[i]])
            if i == end:
                rtnData.append(end-start+1)
                start = end + 1
        return rtnData