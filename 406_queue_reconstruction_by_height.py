from typing import List


class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        """
            https://leetcode.com/problems/queue-reconstruction-by-height/
            Time Complexity - O(n^2)
                'n' is the number of people
                inserting element at an index
            Space Complexity - O(n)
                'Sorting time'
        """
        people.sort(key=lambda x: (-x[0], x[1]))
        queue = []
        for person in people:
            queue.insert(person[1], person)
        return queue


if __name__ == '__main__':
    print(Solution().reconstructQueue([[7, 0], [4, 4], [7, 1], [5, 0], [6, 1], [5, 2]]))
