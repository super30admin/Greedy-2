class Solution:
    # Time Complexity - O(n^2)
    # Space Complexity - O(1) if we're returning the array
    def reconstructQueue(self, people):
        if people is None or len(people) == 0:
            return []
        people = sorted(people, key=lambda x: (-x[0], x[1]))
        result = []

        for person in people:
            result.insert(person[1], person)

        return result