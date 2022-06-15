#Partition Labels

# // Time Complexity : O(N)
# // Space Complexity :O(N)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        hmap={}
        res=[]
        for n, i in enumerate(s):
            hmap[i]=n
        start=0
        end=0
        for i in range(len(s)):
            end = max(end,hmap[s[i]])
            if i==end:
                res.append(end-start+1)
                start=end+1
        return res
            
                
        