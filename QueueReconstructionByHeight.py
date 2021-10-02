"""
Time Complexity : O(n^2) where n is the total number of people 
Space Complexity : O(n) where n is the total number of people 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        if len(people) == 0:
            return [[]]
        result = []
        # First we dsort the elements according to their heights in descending order
        # Also in ascending order of their values for the people with same height
        people.sort(key = lambda x: (-x[0], x[1]))
        # We iterate through the sorted list and rearrage them according to their k 
        # values and return
        for i in people:
            result.insert(i[1], i)
        return result