"""
Time Complexity : O(2n) where n is length of the input string 
Space Complexity : O(1) as hashMap can contain only maximum 26 letters

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach
s = "ababcbacadefegdehijhklij"
1. Maintain the character's last appear index in hashMap
2. Initiailized start and end pointer to 0
3. Then start iterating on the input string and assign end pointer to the last appeared index of the input character
4. Whenever i == end pointer then, append the length of the string in the result
"""
from collections import defaultdict


class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        if len(s) == 0:
            return []
        result = []
        hashMap = defaultdict()

        for i in range(len(s)):
            if s[i] not in hashMap:
                hashMap[s[i]] = 0
            hashMap[s[i]] = i

        start = end = 0

        for i in range(len(s)):
            end = max(end, hashMap[s[i]])
            if i == end:
                result.append(end-start + 1)
                start = i + 1
        return result
