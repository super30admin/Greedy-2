class Solution:
    # Time Complexity - O(n)
    # Space Complexity - O(1)
    def partitionLabels(self, s: str):
        lastIndex = {}

        for i in range(len(s)):
            lastIndex[s[i]] = i

        result = []
        start, end = 0, 0
        for i in range(len(s)):
            end = max(end, lastIndex[s[i]])
            if i == end:
                result.append(end - start + 1)
                start = end + 1

        return result