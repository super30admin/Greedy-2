class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        n = len(s)
        lastIdx = [-1 for i in range(26)]

        for i in range(n):
            idx = ord(s[i]) - ord('a')
            lastIdx[idx] = i
        
        start, end = 0, 0
        res = []
        for i in range(n):
            idx = ord(s[i]) - ord('a')
            end = max(end, lastIdx[idx])
            if end == i:
                res.append(end - start + 1)
                start = end + 1
        return res