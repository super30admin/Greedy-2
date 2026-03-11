# Time Complexity : O(n log n), sorting + insertion
# Space Complexity : O(n), for output list
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# 1. Sort people by height descending, then k ascending.
# 2. Insert each person into result list at index = k.
# 3. Taller people are inserted first, ensuring shorter people are correctly positioned behind taller ones.

from typing import List

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people.sort(key=lambda x: (-x[0], x[1]))
        result = []
        for person in people:
            result.insert(person[1], person)
        return result