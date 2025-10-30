"""
TC: O(N²) {Sorting the list takes O(N log N), and inserting each person at a specific index 
           in the result list requires O(N) in the worst case due to shifting elements, 
           leading to an overall quadratic time complexity.}
SC: O(N) {We use a separate result list to construct the final queue, which stores all people, 
           resulting in linear auxiliary space usage.}

Approach:
We are asked to reconstruct a queue where each person is represented by [h, k], where:
    - h = height of the person,
    - k = number of people in front with height ≥ h.

To ensure the correct order, we first sort the list by:
    - Height in descending order (taller people placed first).
    - k in ascending order (for people of equal height).

Then, we iterate through the sorted list and insert each person at index `k` in the result list.  
Since taller people are already positioned, inserting shorter ones at their `k` index ensures that 
each person has exactly `k` taller or equal-height people in front.

This greedy insertion strategy guarantees correctness and simplicity without explicit simulation.

This problem ran successfully on Leetcode.
"""


class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        temp = sorted(people, key = lambda x: (-x[0], x[1]))
        res = []

        for each in temp:
            res.insert(each[1], each)
        return res