# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        # Find the last occurrence of each character
        last_occurrence = {}
        for i, char in enumerate(s):
            last_occurrence[char] = i
        
        result = []
        start = 0
        end = 0
        
        # Iterate through the string to find partition boundaries
        for i, char in enumerate(s):
            # Update the end boundary to include the last occurrence of current character
            end = max(end, last_occurrence[char])
            
            # If we've reached the end of current partition
            if i == end:
                result.append(end - start + 1)
                start = i + 1
        
        return result
        