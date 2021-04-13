# Time Complexity : O(N^2)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using sorting. First sort the array in descending order with repect to heights of each person and then in ascending order of other people in front
# Iterate over the array and insert into res by getting the index as number of people in front and inserting the current person in that index
# Return res


class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        if not people:
            return None
        people.sort(key=lambda x: (-x[0], x[1]))
        print(people)
        res = []
        for i in range(len(people)):
            res.insert(people[i][1], people[i])
        return res
