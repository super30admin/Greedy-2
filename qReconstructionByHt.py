class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        # T: O(n ** 2), S: O(n)
        # Sort by height in descending order, and by k in ascending order when heights are the same
        people.sort(key=lambda x: (-x[0], x[1]))

        result = []
        for person in people:
            result.insert(person[1], person)  # Insert the person at index k

        return result
