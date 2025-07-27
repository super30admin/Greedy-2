# S30 Problem #142 Partition Labels
#LeetCode #763 https://leetcode.com/problems/partition-labels/description/

# Author : Akaash Trivedi
# Did this code successfully run on Leetcode :  Yes #
# Any problem you faced while coding this : No

# char map storing: last index occurance of that char in string
# go over the string for partitions, first occurance to last from char map
# increase the size greedly if some char is not in the current partition range
# time complexity O(2n) n-> hashmap, n-> partitions
# space complexity O(n) for hashmap
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        cMap = {}
        # store the last occurance in hashmap
        for i,c in enumerate(s):
            cMap[c] = i

        partn = [] # partitions 
        start = 0 # current partition start
        end = 0 # current partition end

        for i,c in enumerate(s):
            # compare with previous end (last occurance of previous char) => greedly take max
            end = max(cMap[c],end)
            if i == end: # end of current partition
                partn.append(end-start+1)
                start = i+1
        return partn        
            
