# Greedy 
# TC: O(N^2)
# SC: O(1)

class Solution:
    def reconstructQueue(self, people):
        
        people = sorted(people, key = lambda x:(-x[0],x[1]))
        print(people)

        ans = []
        
        for p in people:
            ans.insert(p[1],p)
        return ans
        
        
"""

[4,4],[5,0],[5,2],[6,1],[7,0],[7,1]

"""