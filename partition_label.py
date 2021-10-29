# // Time Complexity :O(n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        hmap={}
        for i in range(len(s)):
            hmap[s[i]]=i
        print(hmap)
        res=[]
        start=0
        end=0
        for i in range(len(s)):
            end=max(end,hmap[s[i]])
            if i==end:
                res.append(end-start+1)
                start=end+1
        return res
            