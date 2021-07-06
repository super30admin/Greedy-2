class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        if people is None or len(people)==0:
            return []
        res=[]
        people.sort( key = lambda x: ( -x[0] ,x[1])) 
        print(people)
        for pep in people:
            res.insert(pep[1],pep)
        return res