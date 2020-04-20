'''
Iterative:
Time Complexity: O(n)
Space Complexity: O(n)
Did this code successfully run on Leetcode : Yes
Explanation:

'''
class Solution:
    def compare(self, val, other):
        if val[0] == other[0]:
            return val[1] - other[1]
        else:
            return other[0] - val[0]

    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people = sorted(people, key=cmp_to_key(self.compare))

        res = []
        for person in people:
            res.insert(person[1], person)

        return res