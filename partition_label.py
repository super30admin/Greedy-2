# Time Complexity: O(n)
# Space Complexity: O(1)
from collections import defaultdict


class Solution:
    def partitionLabels(self, s):
        endmap = defaultdict()
        result = []
        n = len(s)
        for i in range(n):
            endmap[s[i]] = i

        start = 0
        end = 0
        for i in range(n):
            end = max(end, endmap[s[i]])

            if i == end:
                result.append(end - start + 1)
                start = end + 1
        return result