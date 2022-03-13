'''
TC: O(n^2)
SC: O(n)
'''

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        plen = len(people)
        if not plen:
            return 0
        
        res = [p for p in people]
        people = sorted(people, key = lambda k : (k[0], -1 * k[1]), reverse = True)
        
        for p in people:
            res.insert(p[1], p)
        
        return res[:plen]
                
        
        
        
        