#Time Complexity - O(n^2)
#Space Complexity - O(n)
from collections import deque
class Solution(object):
    def reconstructQueue(self, people):
        """
        :type people: List[List[int]]
        :rtype: List[List[int]]
        """
        if not people:
            return []
        if len(people) == 1:
            return people
        people = sorted(people, key = lambda x : (-x[0],x[1]))
        q = deque()
        i = 0
        x = people[0][0]
        while i < len(people):
            num = people[i][1]
            temp = []
            while num > 0 and q:
                temp.append(q.popleft())
                num = num - 1
            q.appendleft(people[i])
            for _ in temp[::-1]:
                q.appendleft(_)
            i = i + 1
        return (list(q))