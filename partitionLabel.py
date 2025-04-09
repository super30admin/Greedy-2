"""
Brute force approach -
1. Using two for loops, we do a linear search ==> TC - O(n^2) SC - O(1)
2. Two pointers ==> To check each occurrence we'll still end up looping twice, thus ending up using two for loops and hence causing TC - O(n^2)

HashMap Approach --
TC - O(n)
SC - O(1) ==> since constant number (26) alphabets.
"""
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        if s is None or len(s) == 0: return []

        hmap = {}
        start = 0
        end = 0

        rtnData = []

        n = len(s)

        for i in range(n):
            # add chars to hmap
            # everytime we find the same char, the idx will be updated
            hmap[s[i]] = i

        for i in range(n):
            # update end by comparing with the idx
            end = max(end, hmap[s[i]])
            if i == end:
                rtnData.append(end-start+1)
                # reset start
                start = end + 1
        return rtnData