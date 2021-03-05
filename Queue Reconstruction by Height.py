#time: O(n^2)
#space: O(1)

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        if(people==[]):
            return []
        people=sorted(people, key=lambda x:(-x[0],x[1]))
        result=[]
        print(people)
        for i in people:
            result.insert(i[1],i)
        return result