# Time O(n log n + n)
# Space O(n) # sorted function creates new list
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people = sorted(people, key=lambda x: (-x[0], x[1]))
        n = len(people)
        result = []
        for p in people:
            result.insert(p[1], p)
        return result