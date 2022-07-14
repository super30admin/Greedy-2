# Time Complexity : O(N) where N length of the string
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        hashmap = {}
        result = []
        for index, label in enumerate(s):
            hashmap[label] = index
        
        start = 0
        end = 0
        for i in range(len(s)):
            end = max(end, hashmap[s[i]])
            
            if i == end:
                result.append(end-start + 1)
                start = i + 1
        
        return result