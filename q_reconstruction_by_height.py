#Time complexity - O(N^2)
# Space complexity - O(1)
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people = sorted(people, key=lambda x: (-x[0], x[1]))
        q = []
        for person in people:
            q.insert(person[1],person)
        return q
