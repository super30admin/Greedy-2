# Time Complexity : O(n), n = length of string
# Space Complexity : O(1), constant size array for 26 letters
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# 1. Record the last occurrence of each character.
# 2. Iterate the string while tracking the farthest last occurrence of characters in current partition.
# 3. When current index reaches the farthest point, partition ends.
# 4. Record partition size and start new partition.

from typing import List

class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        last = {c: i for i, c in enumerate(s)}
        result = []
        start = end = 0
        for i, c in enumerate(s):
            end = max(end, last[c])
            if i == end:
                result.append(end - start + 1)
                start = i + 1
        return result