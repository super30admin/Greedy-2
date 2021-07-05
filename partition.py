from typing import List
from collections import deque
import collections


class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        if s is None or len(s) == 0: return None
        lastcharindex = {}
        for idx in range(len(s)):
            lastcharindex[s[idx]] = idx

        print(lastcharindex)

        result = []
        maxvariable = 0
        start = 0

        for idx in range(len(s)):
            maxvariable = max(maxvariable, lastcharindex[s[idx]])

            if maxvariable == idx:
                result.append(idx - start + 1)
                start = idx + 1
        return result


s = "ababcbacadefegdehijhklij"
print(Solution().partitionLabels(s=s))



