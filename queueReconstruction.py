# Leetcode 153. Find Minimum in Rotated Sorted Array

# Time Complexity :  O(n^2) where n is the size of the array

# Space Complexity : O(1)

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Sorting people in the descending order of height and if height is same then in the ascending order 
# of no. of people in front of them. Once the array is sorted insert each person in the people array into the 
# result array at the index of no.of people in front of that person

# Your code here along with comments explaining your approach

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        
        if not people or len(people) == 0:
            return []
        
        # sorting people in descending order of height and if same height then ascending order of no.of people ahead
        people = sorted(people,key = lambda person : (-person[0],person[1]))
        result = []
        for person in people:
            # inserting person at the index based on no.of people in front of him 
            result.insert(person[1],person)
        return result