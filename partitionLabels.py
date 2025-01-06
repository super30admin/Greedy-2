# // Time Complexity :O(n)
# // Space Complexity :O(n) for hashmap
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach


class Solution:
    def partitionLabels(self, s: str) -> list[int]:
        res = []
        locc = {}
        for i in range(len(s)):             # 1 pass to set last index
            c = s[i]
            locc[c] = i

        start, end = 0,0                    # 2 pointers to find partitiosn
        for i in range(len(s)):
            c = s[i]

            end = max(locc[c],end)          # update max at every level

            if i == end:                    # everytime you reach a unique end ; add to result
                res.append(end-start+1)
                start = end + 1             # reset start

        return res
