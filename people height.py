"""
Time Complexity : O(n**2)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Explaination
we sort the array according to the height in descending order and if heights are same then by no of people 
i.e. key = lambda x:(-x[0],x[1])
Then we store these elements into res array according to the no of people ahead
i.e. res.insert(people[1], people) 


"""


class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        if people == None or len(people) == 0: return
            
        people.sort(key=lambda x: (-x[0], x[1]))        
        q = []
        
        for p in people:
            q.insert(p[1],p)
        return q