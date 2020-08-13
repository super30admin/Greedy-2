# Time Complexity : O(n^2), where n is the length of the input array
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
class Solution(object):
    def reconstructQueue(self, people):
        # Edge case
        if not people:
            return []
        # Sort by descending height, if height same
        # ascending number of people in front
        people.sort(key=lambda x: (-x[0], x[1]))
        # positional insertion based on the number of people in front.
        arr = []
        for i in people:
            arr.insert(i[1], i)
        return arr
