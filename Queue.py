# The reconstructQueue method reconstructs a queue based on people's height and the number of taller people in front.

# Sort the input by height and then by position (q).
# Traverse the sorted list:
# - Find the correct position in the output array based on the `q` value.
# - Place the person at the determined index.

# TC: O(n^2) - For each person, find their correct position.
# SC: O(n) - Space for the output list.


from typing import List


class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        N = len(people)
        output = [None] * N
        people.sort()

        for height, q in people:
            i, j = 0, -1
            while i < N:
                if not output[i] or output[i][0] == height:
                    j += 1
                if j == q:
                    break
                i += 1

            output[i] = [height, q]
        
        return output
