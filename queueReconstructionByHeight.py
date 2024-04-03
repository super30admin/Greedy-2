"""
Time Complexity : O(nlogn + n^2)  where n is length of the input list 
Space Complexity : O(1) as hashMap can contain only maximum 26 letters

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach
1. Sort the list descending on the basis of height and if height is equal then ascending on the basis of number of people
2. Then insert into the output array on the basis of number of people
"""


class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people.sort(key=lambda x: (-x[0], x[1]))
        result = []
        for person in people:
            result.insert(person[1], person)
        return result
