'''
Time: O(n^2) due to insert function
Space: O(1)
'''

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        
        people = sorted(people, key = lambda x: (-x[0],x[1]))
        
        res = list()
        
        for p in people:
            res.insert(p[1],p)
            
        return res