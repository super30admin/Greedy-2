# Time Complexity : O(n*n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def reconstructQueue(self, people):
        people.sort(key = lambda x : (-x[0], x[1]))

        queue = []

        for peep in people:
            queue.insert(peep[1], peep)
        
        return queue