# 763. Partition Labels
# https://leetcode.com/problems/partition-labels/

# Logic: We make a hashmap with letter as the key and tha last index as value. 
# We then Iterate over the input and set end variable to the index from hashmap 
# of the current letter. If the cur index equals the end variable we add to answer.

# Time Complexity: O(n)
# Space Complexity: O(1) [only 26 letters possible so O(26)]

from collections import defaultdict
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        hashmap = defaultdict(int)
        res = []
        end = 0
        start = 0
        
        for idx, i in enumerate(s):
            hashmap[i] = idx
        
        for idx, i in enumerate(s):
            end = max(end, hashmap[i])
            
            if idx == end:
                res.append(end - start + 1)
                start = end + 1
        
        return res