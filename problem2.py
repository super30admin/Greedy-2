# T.C=> O(n * n)
# S.C =>O(n)
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        if len(people) == None or people == 0:return[[]]
        # people = sorted(people, key = lambda x: (-x[0], x[1]))
        people = sorted(people, key = lambda x: (-x[0], x[1]))
        print(people)
        result = []
        for p in people:
            result.insert(p[1], p)
        return result

