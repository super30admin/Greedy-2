'''
Problem: Queue Reconstruction by Height
Time Complexity: O(n * n), where n is given elements
Space Complexity: O(n) for sorted array
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        sort the persons on decreasing height and increasing count
        then insert into the resultant array
        we are handling the person with largest height first  
'''

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        sorted_array = sorted(people, key = lambda x: (-x[0], x[1]))
        result = []

        for person in sorted_array:
            result.insert(person[1], person)
        
        return result
