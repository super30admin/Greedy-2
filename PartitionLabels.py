'''
TC: O(n) - go through the input list
SC: O(1) - since there can be maximum 26 characters
'''
from typing import List

class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        end = 0
        mydict = {}
        for i, alpha in enumerate(s):
            mydict[alpha] = i
        count = 1
        res = []
        for i, alpha in enumerate(s):
            end = max(end, mydict[alpha])
            if i == end:
                res.append(count)
                count = 0
            count += 1
        return res
s = Solution()
print(s.partitionLabels("ababcbacadefegdehijhklij"))
print(s.partitionLabels("eccbbbbdec"))