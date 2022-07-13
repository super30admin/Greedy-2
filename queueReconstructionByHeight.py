'''
Time Complexity: O(n*n)
Space Complexity: 0(n)
Run on leetCode: Yes
'''
class People:
    
    '''
    Priority given to height and then to frequency
    height in descending order, in-case of MATCH, frequency in ascending order
    '''
    
    def __init__(self,height,frequency):
        self.height = height
        self.frequency = frequency
    
    # custom operators where priority given to height and then to frequency   
    def __lt__(self, other):
        if (self.height == other.height):
            return self.frequency < other.frequency
        return self.height > other.height

    def __gt__(self, other):
        if (self.height == other.height):
            return self.frequency > other.frequency
        return self.height < other.height

    def __eq__(self, other):
        return (self.height == other.height and self.frequency == other.frequency)
    
class Solution:
    
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        # Step1: sort the height by desc order, if the frequency is SAME, sort in frequency in asc order
        
        # create an object of class people and sort
        peopleObjList = []
        for p in people:
            pObj = People(p[0],p[1])
            peopleObjList.append(pObj)
        peopleObjList.sort()
        
        for p in peopleObjList:
            print(vars(p))
        
        # Step2: consider frequency as an "index" and place the [height,frequency] pair in the index position
        output = []*len(people)
        for people in peopleObjList:
            index = people.frequency
            output.insert(index,[people.height,people.frequency])
        
        return output