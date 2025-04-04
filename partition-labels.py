# Time O(n)
# Space O(1)
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        n = len(s)
        cmap = defaultdict(int)
        for i in range(n):
            cmap[s[i]] = i
        start = 0
        end = 0
        result = []
        for i in range(n):
            if cmap[s[i]] > end:
                end = cmap[s[i]]
            if i == end:
                result.append(end - start + 1)
                start = i + 1
        return result

        