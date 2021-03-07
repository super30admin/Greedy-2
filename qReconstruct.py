class Solution:
    
    """
    Description: reconstruct a queue from a list of lists where 2nd element present number of people equal or greather than 1st element
    
    Time Complexity: O(n^2)
    Space Complexity: O(n)\
    
    Approach:
    1. sort the queue by using reverse height and number of people in front 
    2. in an empty resulting array insert each person one by one on the index identified by 2nd element 
    """
    
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        
        if people == None: return 
        
        people = sorted(people, key = lambda x: (-x[0], x[1]))
        result = []
        for person in people:
            result.insert(person[1], person)
            
        return result
