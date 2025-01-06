# The partitionLabels method divides a string into as many parts as possible such that each character appears in only one part.

# Track the last index of each character in the string.
# Traverse the string, maintaining the current partition's size and its endpoint (`end`).
# - Update the partition's endpoint based on the character's last index.
# - When reaching the endpoint, add the partition size to the result and reset the size.

# TC: O(n) - Single traversal of the string.
# SC: O(1) - Space for the lastIndex dictionary (fixed size for 26 letters).


from typing import List


class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        lastIndex = {}
        for i, c in enumerate(s):
            lastIndex[c] = i
        
        res = []
        size = end = 0
        for i, c in enumerate(s):
            size += 1
            end = max(end, lastIndex[c])

            if i == end:
                res.append(size)
                size = 0
        return res