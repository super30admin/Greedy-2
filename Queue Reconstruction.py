"""
Approach: find all possible permutaiton and check the validity.
TC: O(n!) + O(n)
Approach2: sort: by heigths in increasing order and if they are same sort by people in decreasing. We need to take care of larger
heights first.
if we put smaller heights in front of larger, then the validity is still maintained.
It is greedy because we handle the larger height first. Thus greddy. Try to take the local optimal decision and try to see
if each one of them is taking us to local optimal decision.
In this quesiton try to solve with different arrangments:
 (1) heigths in decreasing order, and if they are the same sort of people in decreasing
 (2)heigths in decreasing order, and if they are the same sort of people in increasing etc
 Then heigths in increasing order and if they are the same sort of people in decreasing takes to gloabla max.
 If this also fails, then DP.
 TC: O(nlogn) # sort + O(n^2) # insert in between of the list for n elements
"""


class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        # sort by decreasing height and increasing people
        people = sorted(people, key=lambda x: (-x[0], x[1]))

        res = []
        print(people)
        for p in people:
            # taller people are already placed first,
            # when a shorter person is inserted at position p[1], it does not affect the
            # relative positions of taller people
            # when travsersing array we are dealing with shorter person and placig them
            # in front of taller.
            res.insert(p[1], p)
            print(res)

        return res
