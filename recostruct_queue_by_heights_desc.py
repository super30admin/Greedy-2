# Time Complexity : O(P*P) where P is number of people in the queue
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        result = []
        people.sort(key= lambda x: (-x[0], x[1]))
        
        for p in people:
            height, tolerance = p
            result.insert(tolerance, p)
            
        return result