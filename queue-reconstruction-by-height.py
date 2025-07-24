# Time Complexity : O(n log n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        # Sort people by height in descending order, and by k in ascending order for same height
        people.sort(key=lambda x: (-x[0], x[1]))
        
        result = []
        
        # Insert each person at their k position
        for person in people:
            result.insert(person[1], person)
            
        return result
        