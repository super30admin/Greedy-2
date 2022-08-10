# time complexity is o(n^2), where n is the size of the input
# space complexity is o(n), where n is the size of the input
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        newlist = sorted(people, key = lambda x:(-x[0], x[1])) #space o(n)
        res = list()
        for i in newlist: #time o(n^2)
            res.insert(i[1], i)
        return res
        