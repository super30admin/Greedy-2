# https://leetcode.com/problems/partition-labels/

class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        last_occurrence = {}
        for i in range(len(s)):
            last_occurrence[s[i]] = i
        
        start, end = 0, 0

        partitions = []
        for i in range(len(s)):
            end = max(end,last_occurrence[s[i]])

            if i == end:
                partitions.append(i - start + 1)
                start = i+1
        
        return partitions

# TC: O(n)
# SC: O(n)