#Time: O(nlog(n))
#space: O(n)
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:

        sortedq= sorted(people, key=lambda x: (-x[0], x[1]))
        result=[]
        for people in sortedq:
            result.insert(people[1],people)
        return result
        
