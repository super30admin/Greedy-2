# // Time Complexity : O(N^2)
# // Space Complexity : O(1) excluding space for output array
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach
# Intuition by observation, by eg.: [6,1],[7,0],[7,1],[8,0],[9,0] => [7,0],[6,1], [7,1],[8,0],[9,0]
# 1. People with same height are sorted by 'k' in [h:height,k:people in front with height>=k]
# 2. Sorting descending height and then for same height in ascending order of k. [9,0],[8,0],[7,0],[7,1],[6,1]
# 3. Now, based on k of each [h,k] in the array after #2, start iterating and move the element to index=k and shift rest elements to the right. [7,0],[6,1],[7,1],[8,0],[9,0]

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        
        people.sort(key = lambda x: (-x[0], x[1]))
        
        output = []
        
        for p in people:
            output.insert(p[1],p)
            
        return output
        
        
        
        