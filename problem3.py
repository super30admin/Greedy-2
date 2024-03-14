#Time Complexity :O(n)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode :Yes
#Any problem you faced while coding this :No

from ast import List

class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        rightmost = {}
        for i, char in enumerate(s):
            rightmost[char] = i
        
        left, right = 0, 0
        result = []
        
        for i, char in enumerate(s):
            right = max(right, rightmost[char])
            
            if i == right:
                result.append(right - left + 1)
                left = i + 1
        
        return result
        