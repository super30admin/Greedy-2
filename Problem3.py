# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#check for last occurence of a character and try to move end pointer to the max extent possible
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        
        if s == None or len(s) == 0:
            return []
        
        hmap = {}
        
        for i in range(len(s)):
            hmap[s[i]] = i
        result = []
        S,e = 0,0
        for i in range(len(s)):
            e = max(e, hmap[s[i]])
            if i == e:
                result.append(e-S+1)
                S = e + 1
                
        return result
            
        