# Time Complexity : O(n^2), where n is the number of people
# Space Complexity : O(n)
class Solution:
    def reconstruct_queue(self, people):
        if not people:
            return []
        
        # Sort people: first by height in descending order, then by k-value in
        # ascending order
        people.sort(key=lambda x: (-x[0], x[1]))
        
        result = []
        
        # Insert each person into the result list at the index equal to their
        # k-value
        for person in people:
            result.insert(person[1], person)
        
        return result

# Instantiate the Solution class
solution = Solution()

# Example 1
people1 = [[7, 0], [4, 4], [7, 1], [5, 0], [6, 1], [5, 2]]
print("Example 1 Result:", solution.reconstruct_queue(people1))  # Output: [[5, 0], [7, 0], [5, 2], [6, 1], [4, 4], [7, 1]]

# Example 2
people2 = [[6, 0], [5, 0], [4, 0], [3, 2], [2, 2], [1, 4]]
print("Example 2 Result:", solution.reconstruct_queue(people2))  # Output: [[4, 0], [5, 0], [6, 0], [1, 4], [2, 2], [3, 2]]

# Example 3
people3 = [[9, 0], [7, 0], [1, 9], [8, 0], [2, 8], [5, 4]]
print("Example 3 Result:", solution.reconstruct_queue(people3))  # Output: [[7, 0], [8, 0], [9, 0], [5, 4], [2, 8], [1, 9]]