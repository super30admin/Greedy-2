# STEPS:
# Sort the people's array in the descending order of height and then ascending order of people in front.
# traverse the sorted array and place every person to the position equal to the number of people in front of them.
# this will shift any person with height greater than theirs and equal number of people in front of them to the next index.
# Time complexity - O(n^2)
# Space complexity - O(n)
# Did this code run on leetcode? - yes

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        # sort the people array
        people = sorted(people, key=lambda p: (-p[0],p[1])) #O(nlogn)
        
        # O(n^2)
        answer = []
        for p in people:
            answer.insert(p[1], p)
        
        return answer
        