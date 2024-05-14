# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        end = 0
        mydict = {}

        for i, alpha in enumerate(s):
            mydict[alpha] = i
        count = 1
        result = []
        for i, alpha in enumerate(s):
            end = max(end, mydict[alpha])
            if i==end:
                result.append(count)
                count=0
            count+=1
        return result