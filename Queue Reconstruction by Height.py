""""// Time Complexity : O(n^2)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""


class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people.sort(key=lambda x: (-x[0], x[1]))

        res = []
        for p in people:
            res.insert(p[1], p)
        return res

# class People:
#     def __init__(self,height,frequency):
#         self.height = height
#         self.frequency = frequency

#     def __lt__(self, other):
#         if (self.height == other.height):
#             return self.frequency < other.frequency
#         return self.height > other.height

# class Solution:
#     def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
#         temp = []
#         for p in people:
#             pObj = People(p[0],p[1])
#             temp.append(pObj)

#         temp.sort()

#         output = []*len(people)
#         for people in temp:
#             index = people.frequency
#             output.insert(index,[people.height,people.frequency])

#         return output



