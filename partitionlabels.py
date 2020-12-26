class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        if not s:
            return []
        dic = {}
        res = []
        for i in range(len(s)):
            dic[s[i]] = i
        start = end = 0
        for i in range(len(s)):
            end = max(end, dic[s[i]])
            if i == end:
                res.append(end - start + 1)
                start = end + 1

        return res