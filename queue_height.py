class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        result = []
        people.sort(key = lambda x: (-x[0], x[1]))
        for i in people:
            result.insert(i[1], i)
        return result

#time complexity - O(n^2), insertion cost

#space complexity - O(1)

#all test cases passed