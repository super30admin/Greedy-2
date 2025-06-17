"""
TC ==> O(n^2)
SC ==> O(N)
"""

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        ans = deque()
        people.sort(key=lambda x: (-x[0], x[1]))

        for person in people:
            ans.insert(person[1], person)

        return list(ans)