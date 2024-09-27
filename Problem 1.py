# Time Complexity : O(n^2)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        # sorted the people based on decreasing height and then sorted based on incresing k value for each height
        people = sorted(people, key=lambda x: (-x[0], x[1]))
        res = []

        # Now we just need to insert the people based on index as insertion will be done from greater height to lower height
        for i in people:
            res.insert(i[1], i)
        return res    