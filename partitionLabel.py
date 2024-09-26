# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def partitionLabels(self, S):
        result = []
        if len(S) == 0:
            return result 
        
        start, end = 0, 0 
        map_ = {}


        for i in range(len(S)):
            map_[S[i]] = i 


        for i in range(len(S)):
            key = map_[S[i]]
            end = max(end, key)
            if i == end:
                result.append(end - start + 1)
                start = end+1
        
        return result