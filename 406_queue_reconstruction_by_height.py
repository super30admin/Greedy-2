"""
Leetcode: https://leetcode.com/problems/queue-reconstruction-by-height/

Approach: Greedy
1. Sort people
    - In the descending order by height.
    - Among the guys of the same height, in the ascending order by k-values.
2. Take guys one by one, and place them in the output array at the indexes equal to their k-values.
3. Return output array.

Time complexity : O(N^2). To sort people takes O(N logN) time. Then one proceeds to n insert operations, and
each takes up to O(k) time, where k is a current number of elements in the list. In total, one needs up to
(O(N^2) time.

Space complexity : O(N) to keep the output.
"""


class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people.sort(key = lambda x: (-x[0], x[1]))
        output = []
        for p in people:
            output.insert(p[1], p)
        return output