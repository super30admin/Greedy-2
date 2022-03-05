"""
You are given a string s. We want to partition the string 
into as many parts as possible so that each letter appears in at most 
one part.

Note that the partition is done so that after concatenating 
all the parts in order, the resultant string should be s.

Return a list of integers representing the size of these parts.
"""

# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        
        res = []
        mp = {}
        start = 0
        end = 0
        
        if s == None and len(s) == 0:
            return res
        
        for i in range(len(s)):
            mp[s[i]] = i
            
        for i in range(len(s)):
            end = max(end, mp[s[i]])
            if i == end:
                res.append(end-start+1)
                start = i + 1
                
        return res