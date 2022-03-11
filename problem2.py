# TC:O(n^2)
# SC:O(1)


class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people.sort(key=cmp_to_key(self.sort1))
        result = []

        for person in people:
            result.insert(person[1],person)
        return result

    def sort1(self,a,b):
        if a[0] == b[0]:
            return a[1]-b[1]

        return b[0] - a[0]
