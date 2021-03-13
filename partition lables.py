"""
Time Complexity : O(n)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Explaination:
We iterate over the string and store the last index of each char into the hasmap
In second iteration we find the end for each partition 
when i == end we know that partition has ended

"""



class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        if S == None or len(S)==0: return []
        mp = {}
        res = []
        end, start = 0,0 
        for i in range(len(S)):
            mp[S[i]] = i
        
        for i in range(len(S)):
            
            end = max(end,mp[S[i]])
            if i == end:
                res.append(i-start+1) 
                start = i+1
        return res
            
        
        
