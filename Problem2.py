# Greedy Approach: 1. Sort in descending order accorging to the heights; if there are of same height then sort with ki values - least first (asc)
# 2. Iterate again and insert them according ki value position
# Basically I am keeping taller people at the front which means, once I sort it i can keep shorter people anywhere before

# Time: O(nlogn) + O(n2) = O(n2); Space: O(n)
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        res = []
        # Note: Go through lambda functions
        people = sorted(people, key=lambda x: (-x[0], x[1]))

        # O(n2)
        for [x, y] in people:
            res.insert(y, [x, y])
        return res




