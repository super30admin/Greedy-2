# Time Complexity: O(n2)
# Space Complexity: O(n)
class Solution:
    def reconstructQueue(self, people):
        n = len(people)

        people.sort(key=lambda x: (-x[0], x[1]))

        result = []
        for p in people:
            #             It will take the location that is k in p and add current person at that location in queue
            h = p[0]
            k = p[1]
            result.insert(k, [h, k])
        return result



