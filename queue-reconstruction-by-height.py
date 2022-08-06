# Time Complexity: O(n^2)
# Space Complexity: O(n)
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        if poeple==None or len(people)==0: return None
        people.sort(key=lambda x:(-x[0],x[1]))
        result=[]
        for i in people:
            result.insert(i[1],i)
        return result