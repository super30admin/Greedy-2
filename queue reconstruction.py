# TC:O(N^2)
# SC:O(N)

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:

        if not people or len(people)==0:
            return []

        res=[]

        people.sort(key=lambda x:[-x[0],x[1]])

        #print(people)

        for i in range(len(people)):
            res.insert(people[i][1],people[i])

        return res