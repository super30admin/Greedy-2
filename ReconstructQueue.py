--------------------------Reconstruct Queue------------------------------------------
# Time Complexity : O(N**2) as N is length of people 
# Space Complexity : O(N) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# first we will sort the people array with decrementing with height, and increasing order of number of people seen. 
# and iterate through the array and insert elements into the resultant array with index of sorted people number of index.

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        if not people:
            return []
        
        people.sort(key = lambda p: [-p[0], p[1]])

        res = []
        for i in range(len(people)):
            temp = people[i]
            res.insert(temp[1], temp)
        return res