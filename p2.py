#Time: O(n^2)
#Space: O(n)
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        if people is None or len(people) < 1:
            return None

        people.sort(key = lambda x: (-x[0], x[1]))
        result = [None for _ in range(len(people))]

        for h, k in people:
            if result[k] is not None:
                shift_ind = len(people) - 1
                while shift_ind > k:
                    result[shift_ind] = result[shift_ind - 1]
                    shift_ind -= 1
            result[k] = [h, k]

        return result
