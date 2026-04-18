# Time Complexity : O(n^2)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : First, we sort the people by height in descending order, and if heights match, by the number of taller or equal people they expect ahead (in ascending order).
# Then we insert each person at the index equal to how many taller or equal people should be in front of them.
# Since taller people are already placed, inserting at that index ensures everyone sees exactly the number of taller or equal people they expected.

class Solution:
    def reconstructQueue(self, people):
        people.sort(key=lambda a: (-a[0], a[1]))
        
        result = []
        for p in people:
            result.insert(p[1], p)
        
        return result

