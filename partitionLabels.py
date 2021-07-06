# Time Complexity : O(n), where n is the length of the input string
# Space Complexity : O(1), HashMap space ignored, max unique char 26 only.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
class Solution(object):
    def partitionLabels(self, S):
        # Edge case
        if not S:
            return []
        # Populating HashMap
        store = {}
        for i in range(len(S)):
            store[S[i]] = i
        # Logic
        retVal = []
        start, end = 0, 0
        for i in range(len(S)):
            end = max(end, store[S[i]])
            if i == end:
                retVal.append(end - start + 1)
                start = end + 1

        return retVal

