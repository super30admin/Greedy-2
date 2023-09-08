# Time Complexity :O(N*N)
# Space Complexity :O(N)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach



from collections import deque
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people.sort(key=lambda x: (x[0]*-1, x[1]))
        q=deque()
        for i in range(len(people)):
            q.insert(people[i][1], people[i])
        people=[]
        for i in q:
            people.append(i)
        return people