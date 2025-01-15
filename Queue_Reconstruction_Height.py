# Explain your approach in brief:
# The key idea is to sort the people array such that taller people with higher heights are placed before shorter ones.
# If two people have the same height, sort them by their `k` value in ascending order.
# Then, insert each person into the output queue based on their `k` value, which ensures that their relative order is correct.

# Time Complexity: O(N^2) - Sorting takes O(N log N), and inserting each person into the queue takes O(N) in the worst case.
# Space Complexity: O(N) - Space for the output queue.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        # Sort people: descending by height (hi), and ascending by k if heights are the same
        people.sort(key=lambda x: (-x[0], x[1]))
        
        # Initialize an empty queue to reconstruct the result
        queue = []
        
        # Insert each person into the queue based on their k-value
        for person in people:
            # Insert the person at the index specified by their k-value
            queue.insert(person[1], person)
        
        return queue
