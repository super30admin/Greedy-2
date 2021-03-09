# Time Complexity : O(N^2)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        #sort people by descending height and increase people (k)
        people.sort(key = lambda x: (-x[0], x[1]))

        queue = []
        for i in people:
            queue.insert(i[1], i)
            
        return queue