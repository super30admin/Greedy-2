class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        """
        TC:O(n^2)
        SC:O(1)
        """
        res=[]
        people.sort(key=lambda x:(-x[0], x[1]))
        print(people)
        for i in range(len(people)):
            res.insert(people[i][1], people[i])
        print(res)
        return res
        