# Time Complexity :O(N)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach


class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        h={}
        for i in range(len(s)):
            h[s[i]]=h.get(s[i],0)
            h[s[i]]=i
        i=0
        low=0
        high=h[s[0]]
        result=[]
        for i in range(len(s)):
            if(h[s[i]]>high):
                high=h[s[i]]
            if(i==high):
                result.append(high-low+1)
                low=i+1
        return result
        