# Time complexity : O(n^2)
# Space complexity : O(1)
# Leetcode : Solved and submitted

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        # check for null case
        if not people or len(people) == 0:
            return []
        res = []
        
        # sort the people array with descending height which is x[0] and increasing k, which is x[1]
        people.sort(key = lambda x: (-x[0], x[1]))
        
        # insert the people in res at the index which is the second index in the array
        for i in range(len(people)):
            res.insert(people[i][1],people[i])
        
        # return res
        return res
