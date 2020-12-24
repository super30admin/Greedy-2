# APPROACH 1: Greedy solution 
# Time Complexity : O(n), n: length of S
# Space Complexity : O(1), hashmap will always be of constant size 26 lowercase letters. 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None 
#
#
# Your code here along with comments explaining your approach
# 1. Store the index of last occureence of each of the char in S. 
# 2. For the first char, check all the chars within the first char's last occurring index (current window) 
#         -> if the char's last occurrence index is within this current window -> GOOD
#         -> if the char's last occurrence index is not within this current window, then incfease the current window to this char's last index
# 3. Keep doing this till all char's last occurrence index is within the current window. Store the length of this window in the result. And start a new window. 
# 4. Keep doing this till we reach end of S. At end don'tforget to add the length of the last window. 


class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        
        if S is None or len(S) < 1:
            return None
        
        hashmap_last_ind = {}
        for ind in range(len(S)):
            hashmap_last_ind[S[ind]] = ind
            
        result, curr_window, start = [], hashmap_last_ind[S[0]], 0
        for ind in range(len(S)):
            if ind <= curr_window:
                if hashmap_last_ind[S[ind]] < curr_window:
                    continue
                if hashmap_last_ind[S[ind]] > curr_window:
                    curr_window = hashmap_last_ind[S[ind]]
            elif ind > curr_window:
                result.append(ind - start)
                curr_window = hashmap_last_ind[S[ind]]
                start = ind
        
        result.append(ind - start + 1)
        return result
