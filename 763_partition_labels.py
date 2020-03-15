from typing import List


class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        """
            https://leetcode.com/problems/partition-labels/
            Time Complexity - O(n)
            Space Complexity - O(1)
            # Always 26 char in dic
            'n' is the length of string 'S'.
        """
        dic = {}
        for i in range(len(S)):
            dic[S[i]] = i

        start = end = 0
        result = []

        for i in range(len(S)):
            new_end = dic[S[i]]
            end = max(end, new_end)
            if i == end:
                result.append(end - start + 1)
                start = end + 1
        return result
