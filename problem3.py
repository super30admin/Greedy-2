# TC:O(n)
# SC:O(n)

class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        if s is None or len(s) == 0:
            return []

        hmap = {}
        for i, c in enumerate(s):
            hmap[c] = i

        start = 0
        end = 0
        result = []

        i = 0
        while i < len(s):
            end = max(end, hmap[s[i]])

            if end == i:
                result.append(end - start + 1)
                start = end + 1

            i += 1

        return result