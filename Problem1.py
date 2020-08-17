"""
// Time Complexity :o(nlogn)
// Space Complexity : constant
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
"""

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        
        res = []
        people = sorted(people, key = lambda x: (-x[0], x[1])) #sort first in descending order of height and then in ascendding order of number of people
        
        for i in people: #go over the sorted list
            res.insert(i[1],i) #place at the index as per the number of people
         
        return res