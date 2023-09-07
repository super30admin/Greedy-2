# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this problem run on Leetcode: Yes
# Any issues faced doing this problem: No

class Solution(object):
    def partitionLabels(self, s):
        """
        :type s: str
        :rtype: List[int]
        """
        last = {}
        for i in range(len(s)):
            last[s[i]] = i
        most = 0
        res = []
        c = 0
        for i in range(len(s)):
            c = (c + 1)
            if (last[s[i]] > most):
                most = last[s[i]]
            if (last[s[i]] == most) and (i == most):
                res.append(c)
                most = 0
                c = 0
        return res