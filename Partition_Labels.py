# Time complexity : O(n)
# Space complexity : O(1)
# Leetcode : Solved and submitted

class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        n = len(s)
        
        if not s or len(s) == 0:
            return []
        # make a hashmap to store the last index of any character
        hashmap = {}
        
        for i in range(n):
            ch = s[i]
            hashmap[ch] = i
        res = []
        
        # fetch the start as 0 and end as the last seen index of the first character
        start = 0
        end = hashmap[s[0]]
        
        for i in range(n):
            ch = s[i]
            # end will be updated if we find a character in the current partition which has higher last index
            end  = max(end, hashmap[ch])
            
            # if we reach the end of the partition, then find the length of it
            if i == end:
                res.append(end - start + 1)
                start = i + 1
        
        return res
