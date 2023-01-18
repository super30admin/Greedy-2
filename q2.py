# Time Complexity : T(n), Where n is the number of elements in the people list 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing Specific

from typing import List

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        #First we should sort the elements in the people list based on decreasing order of h and increasing order of k 
        people.sort(key= lambda x:(-x[0], x[1]))
        #print(people)
        res=[]
        for i in people:
            res.insert(i[1],i)
        return res