# As tught in class, using sort and insert to solve this problem
#Time complexity: O(nlogn)
#Space complexity: O9n
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people.sort(key= lambda x:(-x[0],x[1]))
        q = list()
        for person in people:
            q.insert(person[1],person)
        return q