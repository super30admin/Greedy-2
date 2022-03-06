"""
time: O(NlogN)
space: O(N)
"""

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people = sorted(people, key=lambda x: (-x[0], x[1]))
        ans = []
        for i, (height,freq) in enumerate(people):
            if i >= freq:
                ans.insert(freq,[height,freq])
        
        return (ans)