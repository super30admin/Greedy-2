# Time Complexity : O(N), where N is the length of the string s. 
# Space Complexity : O(1)
from typing import List


class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        last_indices = {c: i for i, c in enumerate(s)}
        start, end = 0, 0
        result = []
        for i, c in enumerate(s):
            end = max(end, last_indices[c])
            if i == end:
                result.append(end - start + 1)
                start = end + 1
        return result