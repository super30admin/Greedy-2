# Time Complexity: O(n^2)
# Space Complexity: O(n)
# Ran on Leetcode: Yes

from functools import cmp_to_key
class Solution:
    def comparator(self, a, b):
        if a[0] == b[0]:
            return a[1] - b[1]
        return b[0] - a[0]
        
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        if not len(people):
            return [[]]
        res = []
        people = sorted(people, key = cmp_to_key(self.comparator))
        for person in people:
            res.insert(person[1], person)
        return res
        
        