class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        if people is None or len(people) == 0: return None

        people = sorted(people, key=lambda x: (-x[0], x[1]))
        res = []
        for loc in people:
            res.insert(loc[1], loc)

        return res