# // Time Complexity : o(n)
# // Space Complexity : o(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no
 

# // Your code here along with comments explaining your approach
# First, we find the last position of every character in the string.
# Then while scanning the string, we keep track of the farthest last index of any character seen so far.
# When our current index reaches that farthest index, we cut a partition and continue from the next character.

from typing import List
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        map = {}
        res = []
        end = 0
        start = 0
        for i in range(len(s)):
            c = s[i]
            map[c] = i
        for i in range(len(s)):
            c = s[i]
            end = max(end, map[c])
            if i == end:
                res.append(end-start+1)
                start = i+1
        return res
        