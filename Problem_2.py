# Time Complexity: O(n^2)
# Space Complexity: O(1)
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        if people == None or len(people) == 0:
            return []
        people.sort(key = lambda x: (-x[0], x[1]))
        result = []
        for person in people:
            result.insert(person[1], person)
        return result