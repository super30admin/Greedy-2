#Time Complexity : O(N^2)
#Space Complexity : O(N)

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        
        #Sort the array in decreasing order based on first element
        people.sort(key = lambda x: (-x[0], x[1]))
        
        print(people)
        result = []
        
        
        for val in people:
            
            result.insert(val[1], [val[0],val[1]])
            
        return result
