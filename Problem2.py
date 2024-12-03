# Problem 2: Queue Reconstruction by Height
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        result = []
        people.sort(key = lambda p: (-p[0],p[1]))
        
        for pe in people:
            result.insert(pe[1], pe)

        return result
            
        