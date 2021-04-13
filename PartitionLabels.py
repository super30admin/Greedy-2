# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using Greedy Approach. Initialize a HashMap and get the last index of each unique element as value
# Initialize start and end to 0 first
# Then iterate over the array and check if the end is smaller than the current end by getting the value from the HashMap
# For example if the string is "abcabc" so the current end will be at 3 but b's end is at 4 so getting max between (3, 4)
# Then check if the current index is at the end so that becomes the first partition
# We will append end - start + 1 to res and start will be end + 1 for next partition
# Return res


class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        if not S:
            return None
        dict = {}
        for i in range(len(S)):
            dict[S[i]] = i

        start = 0
        end = 0
        res = []
        for i in range(len(S)):
            end = max(end, dict[S[i]])
            if i == end:
                res.append(end - start + 1)
                start = end + 1

        return res
