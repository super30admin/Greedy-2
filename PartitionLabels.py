# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution(object):
    def partitionLabels(self, s):
        """
        :type s: str
        :rtype: List[int]
        """
        
        d={}
        res=[]
        for i in range(len(s)):
            d[s[i]]=i
        maximum=0
        prev=-1
        for i in range(len(s)):
            maximum=max(d[s[i]],maximum)
            if maximum==i:
                res.append(maximum-prev)
                prev=i
                maximum=0
        return res