"""
Time Complexity : O(n^2)- n logn for sorting and n^2 for insertion in the array
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Here, the basic idea is, to first sort the list in descending oreder based on their heights, and if same,
in ascending order based on the number of people in front of them. After that, we iterate through the list
fetch the number of people in front of that person and put that value on that location.
"""


class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people.sort(key=lambda x: (-x[0], x[1]))
        result = []
        for p in people:
            result.insert(p[1], p)
        return result
