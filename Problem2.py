# Problem 2 : Queue Reconstruction by Height
# Time Complexity : O(n^2) where n is the size of the people list
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        # sorting the people list in place with descending height(0th element in person) and when height is same then ascending with kvalue(1th element in person)
        people.sort(key= lambda x: (-x[0], x[1]))

        # define result which store the result list
        result = []
        # loop through people list
        for person in people:
            # insert the person at person[1]th position in the result list
            result.insert(person[1], person)
        # return result list
        return result
