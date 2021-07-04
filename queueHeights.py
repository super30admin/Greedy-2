"""
Time Complexity : O(n^2) 
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this: none
"""

class Solution:
    def reconstructQueue(self, people):
        result = []
        if not people or len(people) == 0:
            return result
        
        people.sort(key=lambda x: (-x[0], x[1]))
        
        for p in people:
            result.insert(p[1], p)
            
        return result