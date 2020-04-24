'''
Solution:
1.  Using a custom comparator, sort the people's info according to heights of descending order
    and if heights are same, then according to k values in ascending order.
2.  Now, from the sorted array, place the person at the index in the array which is equal to the
    current person's k value and the queue will be reconstructed.

Time Complexity:    O(N^2)  |   Space Complexity:   O(1)    assuming sorting takes O(1) space
--- Passed all testcases successfully on leetcode.  
'''


class PeopleInfo:
    
    def __init__(self, h, k):
        self.h = h
        self.k = k
    
    #   custom operators where priority given to height and then k   
    def __lt__(self, other):
        if (self.h == other.h):
            return self.k < other.k
        return self.h > other.h
    
    def __gt__(self, other):
        if (self.h == other.h):
            return self.k > other.k
        return self.h < other.h
    
    def __eq__(self, other):
        return (self.h == other.h and self.k == other.k)
    
    def __repr__(self):
        return '{},{}'.format(self.h, self.k)

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        
        #   initialization
        people = [PeopleInfo(people[i][0], people[i][1]) for i in range(len(people))]
        
        #   sort the people according to heights first and then values of k
        people.sort()
        
        finalResult = []
        
        #   for every person, insert into the index = person's k value 
        for eachPerson in people:
            
            index = eachPerson.k
            finalResult.insert(index, [eachPerson.h, eachPerson.k])
        
        #   return the final array
        return finalResult