# Time Complexity : O(n)
# Space Complexity : O(1) as atmost 26 characters
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : First, we find the last position of every character in the string.
# Then while scanning the string, we keep track of the farthest last index of any character seen so far.
# When our current index reaches that farthest index, we cut a partition and continue from the next character.

class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        map = {}

        for i in range(len(s)):
            c = s[i]
            map[c] = i

        result = []

        start = 0
        end = 0

        for i in range(len(s)):
            c = s[i]
            end = max(end, map[c])

            if i == end:
                result.append(end - start + 1)
                start = i + 1

        return result
