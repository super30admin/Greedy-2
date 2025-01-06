# // Time Complexity :nlogn + n^2
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :Yes


# // Your code here along with comments explaining your approach
class Solution:
    def reconstructQueue(self, people: list[list[int]]) -> list[list[int]]:
        res = []
        people = sorted(people, key=lambda x: (-x[0], x[1]))    # desc col 1, asc col 2

        # print(sorted_data)
        
        # for i, v in enumerate(people):
        #     print(i, v)

        for p in people:
            res.insert(p[1],p)                          # at index p[1] insert p


        return res