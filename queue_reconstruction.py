# Time Complexity : O(n^2)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
from typing import List, collections
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        res = []
        people = sorted(people, key = lambda x:(-x[0], x[1]))

        for person, index in people:
            res.append([person, index])
            i=len(res)-1
            while i!=index:
                res[i], res[i-1] = res[i-1], res[i]
                i-=1
        return res