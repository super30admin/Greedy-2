# Time Complexity : O(N) where N is the length of the input list
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am using a greedy approach to partition the string into as many parts as possible such that each letter appears in at most one part.
# I first create a mapping of each character to its last occurrence index in the string.
# Then, I iterate through the string while maintaining the current partition's end index.
# Whenever the current index matches the end index, it indicates the end of a partition.
# I then calculate the size of the partition and update the start index for the next partition.
# Finally, I return the list of partition sizes.


from typing import List
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        mapy = {}
        for i in range(len(s)):
            mapy[s[i]] = i
        res = []
        start = 0
        end = 0
        for i in range(len(s)):
            end = max(end,mapy[s[i]])
            if i == end:
                res.append(end- start + 1)
                start = i + 1
        return res
         

        