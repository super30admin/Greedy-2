# Time Complexity: O(n^2) + O(n* log n)
# Space Complexity: O(1)        
        
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        if not people: return []
        
        people.sort(key = lambda x:(-x[0], x[1]))
        
        result = []
        for p in people:
            result.insert(p[1], p)      # Inserts at that idx and pushes elems from idx to back.
        
        return result