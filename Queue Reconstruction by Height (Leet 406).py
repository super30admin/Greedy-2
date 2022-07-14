'''
Time: O(n^2) due to insert function
Space: O(1)
'''

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        
        people = sorted(people, key = lambda x: (-x[0],x[1]))
        
        res = list()
        
        for p in people:
            res.insert(p[1],p)
            
        return res



# Alternative using class objects


class People:

    '''
    Priority given to height and then to frequency
    '''

    def __init__(self,height,frequency):
        self.height = height
        self.frequency = frequency

    def __lt__(self, other):
        if (self.height == other.height):
            return self.frequency < other.frequency
        return self.height > other.height

# arr.sort() should work