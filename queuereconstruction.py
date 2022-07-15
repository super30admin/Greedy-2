#Time Complexity: O(n*2)
#Space Complexity: O(1)
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people.sort(key = lambda x:x[1])
        people.sort(key = lambda x:x[0], reverse = True)
        res = []
        for i in range(len(people)):
            person = people[i]
            res.insert(person[1],person)
        return res