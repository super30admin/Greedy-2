class Solution:
    # tc O(n^2), sc O(n).
    def reconstructQueue(self, people):
        people.sort(key = lambda x: (-x[0], x[1]))
        output = []
        for p in people:
            output.insert(p[1], p)
        return output