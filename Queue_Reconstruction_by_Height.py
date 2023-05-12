# Time Complexity : O(N^2), where N is the length of the people array.
# Space Complexity : O(N), where N is the length of the people array.
from typing import List


class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        # sort people by height in descending order and k in ascending order
        people.sort(key=lambda x: (-x[0], x[1]))
        
        # insert people at kth position
        queue = []
        for p in people:
            queue.insert(p[1], p)
        
        return queue