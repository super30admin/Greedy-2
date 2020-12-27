#Time Complexity : O(n^2)+O(NlogN) --->O(N^2)
#Space Complexity : O(1)


class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
      
        people.sort(key=lambda x:(-x[0], x[1])) #sort X[0] in reverse and the tie breaker would be x1 in ascending
        #print(people)
        res = []
        
        for person in people:
            res.insert(person[1], person)
            #print(res)
        
        return res
        
     