
#Time Complexity : O(n)
#Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        hm = {}
        res = [0]
        for i in range(len(s)):
            hm[s[i]] = i
        for i in range(len(s)):
            if not hm[s[i]] <= res[-1]:
                res[-1] = hm[s[i]]
            if i == res[-1]:
                res[-1] += 1
                if not i == len(s)-1:
                    res.append(0)
        for i in range(len(res)-1, 0, -1):
            res[i] = res[i] - res[i-1]
        return res
