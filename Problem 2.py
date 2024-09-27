# Time Complexity : O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        lst_idx = {}
        # lst_idx is dictionary for storing last index for each of the letters
        for i, c in enumerate(S):
            lst_idx[c] = i

        # start and end of the partition
        start = end = 0
        ans = []
        # iterating over the string and finding each partion
        for curr, c in enumerate(S):
            end = max(end, lst_idx[c])
            # if our current index is equal to the end of the partition then append the length to the ans
            if curr == end:
                ans.append(end - start + 1)
                start = end + 1
        return ans
