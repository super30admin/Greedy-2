#TC:O(n)
#SC:O(n)
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people = sorted(people,key = lambda data:(-data[0],data[1]))
        ans = [people[0]]
        for data in people[1:]:
            ans.insert(data[1],data)
        return ans