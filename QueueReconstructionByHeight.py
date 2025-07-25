# // Time Complexity : o(n2)
# // Space Complexity : o(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no


# // Your code here along with comments explaining your approach
# First, we sort the people by height in descending order, and if heights match, by the number of taller or equal people they expect ahead (in ascending order)
# Then we insert each person at the index equal to how many taller or equal people should be in front of them.
# Since taller people are already placed, inserting at that index ensures everyone sees exactly the number of taller or equal people they expected.

from typing import List
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people.sort(key=lambda a:(-a[0], a[1]))
        res = []
        for p in people:
            res.insert(p[1], p)
        return res

        