# S30 Problem #141 queue reconstruction by height
#LeetCode #406 https://leetcode.com/problems/queue-reconstruction-by-height/description/

# Author : Akaash Trivedi
# Did this code successfully run on Leetcode :  Yes #
# Any problem you faced while coding this : No

# sort descending order for heights and ascending for numbers of peoples ahead
# insert each person according to index of people in front
# as taller people are already placed, inserting at index ensure that the number of taller people they expected
# Time Complexity O(n^2) for inserting + O(n log n) for sorting
# Space Complexity : O(n)
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        # negative -x[0] sort first element in descending order
        # x[1] sorts second element in ascending
        speople = sorted(people, key=lambda x: (-x[0],x[1])) 
        
        res = []
        # insert element at index according to number of people (x[1])
        for p in speople:
            res.insert(p[1],p)
        
        return res
