#Time complexity: O(n*n)
#Space complexity: O(n)
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        res=[]
        people.sort(key= lambda x: x[1])
        people.sort(key= lambda x: x[0],reverse=True)
        for i in people:
            index=i[1]
            res.insert(index,i)
        return res
        