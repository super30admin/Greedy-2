"""
Leetcode: https://leetcode.com/problems/partition-labels/

Approach: Greedy

Time Complexity: O(N), where N is the length of S.
Space Complexity: O(1) to keep data structure last of not more than 26 characters.
"""


class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        last = {c: i for i, c in enumerate(S)}
        j = anchor = 0
        ans = []
        for i, c in enumerate(S):
            j = max(j, last[c])
            if i == j:
                ans.append(i - anchor + 1)
                anchor = i + 1

        return ans