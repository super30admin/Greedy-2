class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        #Approach: Greedy
        #Time Complexity: O(n^2)
        #Space Complexity: O(1)
        #where, n is the length of the 'people' list
        
        #sorting list by descending height and ascending 'k'
        people.sort(key = lambda x: (-x[0], x[1]))
        
        result = []
        for p in people:
            result.insert(p[1], p)
            
        return result