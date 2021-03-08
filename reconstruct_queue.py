# Approach
# Time - O(N ^ 2)
# Space - O(1)

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
       
        #sorting list according to descending height and ascending 'k' value
        people.sort(key = lambda x: (-x[0], x[1]))

        result = []
        for p in people:
            result.insert(p[1], p)

        return result 