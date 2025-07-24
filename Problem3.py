"""
I first sorted the people in descending order of height and, for those with the same height, by ascending order of k. This ensures taller people are placed first, which won't be affected by shorter ones. Then, I iterated through the sorted list and inserted each person at their k-index in the result list, which ensures they have exactly k people in front who are taller or equal. 
Time Complexity: O(n^2)
Space Complexity: O(n)
"""
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people.sort(key = lambda x: (-x[0], x[1]))
        result = []
        for person in people:
            result.insert(person[1], person)
        return result  