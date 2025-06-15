# Time Complexity : O(2n)
# Space Complexity : O(1)
class Solution:
    def partitionLabels(self, s: str):
        charMap = {}
        start = 0
        end = 0
        res = []
        print(len(s))

        for i in range(len(s)):
            charMap[s[i]] = i

        while end < len(s):
            end = charMap[s[start]]
            i = start
            while i <= end:
                end = max(end, charMap[s[i]])
                i += 1
            res.append(end - start + 1)
            start = i
            if start == len(s): break

        return res