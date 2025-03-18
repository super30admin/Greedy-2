    # Time = O(n^2)
    # Space = O(n) 
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        # Sort people in descending order of height (h), and ascending order of k
        people.sort(key=lambda x: (-x[0], x[1]))
    
        queue = []
        
        # Insert each person into the queue at the position specified by k
        for p in people:
            queue.insert(p[1], p)
        
        return queue