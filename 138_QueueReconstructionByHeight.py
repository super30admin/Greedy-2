'''
Accepted on leetcode(406)
time - O(NlogN)
space - O(1)
'''


class Solution:
    def reconstructQueue(self, people):
        # sort h(height) in descending order and k(people in front) in ascending order.
        people.sort(key=lambda x: (-x[0], x[1]))

        result = []
        # insert the elements from the sorted array into the result array at kth position each time for all elements.
        for p in people:
            result.insert(p[1], p)
        return result