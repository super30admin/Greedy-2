# Time Complexity : O(N^2) where N is the length of the input list
# Space Complexity : O(N) for storing the result list
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am using a greedy approach to reconstruct the queue based on height and the number of people in front.
# First, I sort the list of people in descending order of height. If two people have the same height, I sort them in ascending order of the number of people in front.
# Then, I iterate through the sorted list and insert each person into the result list at the index equal to the number of people in front of them.
# This ensures that taller people are placed first, and the relative order of people with the same height is maintained.
# Finally, I return the reconstructed queue
from typing import List
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people.sort(key=lambda a:(-a[0],a[1]))
        res = []
        for i in people:
            res.insert(i[1],i)
        return res
        