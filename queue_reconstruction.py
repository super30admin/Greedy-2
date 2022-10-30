# Time -> O(n^2)
#Space => O(1)

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people=sorted(people,key=lambda x:(-x[0],x[1]))
        res=[]
        for i in people:
            res.insert(i[1],i)
            
        return res