# 406. Queue Reconstruction by Height
# https://leetcode.com/problems/queue-reconstruction-by-height/

# Time Complexity: O(nlogn)
# Space Complexity: O(1)

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people.sort(key = lambda x: (-x[0], x[1]))
        
        res = []
        
        for i in people:
            res.insert(i[1], i)
        return res