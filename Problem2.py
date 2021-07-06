"""
// Time Complexity : o(n)
// Space Complexity : o(1), constant, 26 alphabets
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
"""

from collections import defaultdict

class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        d = defaultdict(int)
        #print(len(S))
        for i in range(len(S)): #storing the index of last occurance
            d[S[i]] = i
            #print(i)
        #print(d)
            
        start = 0 #initial start of window
            
        end = d[S[0]] #initial end of window
        
        res = []
        
        for i in range(len(S)):
            if d[S[i]] > end: #if for any char in current window, the last index is beyond the window, we expand it
                end = d[S[i]]
                
            if  i == end: #when entire window has been traversed, add the length of window to res and update start and end index, with next element values
                res.append(end- start + 1)
                start = i+1
                if i < len(S) - 1: 
                    end = d[S[i+1]]
                
        return res
                
            
        
        