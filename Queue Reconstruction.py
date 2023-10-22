# Time Complexity : O(nlog(n) + n^2)
# Space Complexity : O(1)
# Code ran on LeetCode
# Sort the list in descending order wrt 0th index and the 1st index in ascending order. Iterate over the sorted list, for evry element x, its correct position is given by x[1]. Place the element at that index and move all the remaining elements to right.

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people = sorted(people, reverse=True, key=lambda x: (x[0], -x[1]))
        que = []
        for i in people:
            que.insert(i[1], i)
        return que
