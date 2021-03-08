#Time Complexity: O(N*N)
#Space Complexity: O(N)
#Run on Leetcode: Yes
#Any Issues: No

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        res = []
        people.sort(key = lambda x: (-x[0] , x[1]))
        for i in people:
            res.insert(i[1],i)
        return res