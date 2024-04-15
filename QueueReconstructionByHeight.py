'''
TC: O(n^2) - since we are iterating over the array and inserting 
            the nodes in between 
SC: O(n) - due to sorting 
'''
from typing import List

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        res = []
        people = sorted(people, key = lambda x:(-x[0],x[1]))
        for person, index in people:
            res.append([person,index])
            i = len(res)-1
            while i!=index:
                res[i],res[i-1] = res[i-1],res[i]
                i-=1
        return res
s = Solution()
print(s.reconstructQueue([[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]))
print(s.reconstructQueue([[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]))