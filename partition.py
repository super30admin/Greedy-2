# // Time Complexity :O(n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# we keep tarck of last index of each alphabet and create a window with the end as the end we caluclated - now we stop the window when the end has been reached -
class Solution(object):
    def partitionLabels(self, s):
        """
        :type s: str
        :rtype: List[int]
        """
        # O(n), O(1)
        res=[]
        hmap={}
        for i in range(len(s)):
            c=s[i]
            hmap[c]=i
        start=0
        end=0
        for i in range(len(s)):
            c=s[i]
            end=max(end, hmap[c])
            if(i==end):
                
                res.append(end-start+1)
                start=i+1
        return res



        