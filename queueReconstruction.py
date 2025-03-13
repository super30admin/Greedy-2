class Solution:
    # TC : O(n**2)
    # SC : O(1)
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        if people is None:
            return []
        people.sort(key = lambda x:(-x[0],x[1]))
        res = []
        for person in people:
            res.insert(person[1],person)
        return res
