"""
Time Complexity : O(n) 
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this: none
"""

class Solution:
    def partitionLabels(self, S):
        start = 0
        end = 0
        idx_map = {}
        n = len(S)
        result = []
        
        for i in range(n):
            idx_map[S[i]] = i
            
        for i in range(n):
            if idx_map[S[i]] >= end:
                end = idx_map[S[i]]
                
            if i == end:
                result.append(end-start+1)
                start = i + 1
                
        return result