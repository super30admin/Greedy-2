# Explain your approach in brief:
# The main idea is to use the last occurrence of each character in the string to determine partitions.
# Traverse the string while maintaining the current partition's range using the last occurrence indices.
# Whenever the current index matches the end of the partition, we finalize the partition and start a new one.

# Time Complexity: O(N), where N is the length of the string. We traverse the string twice: once to find last occurrences, and once to determine partitions.
# Space Complexity: O(1), as the space used for storing the last occurrence of each character is fixed (26 lowercase English letters).
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        # Step 1: Store the last occurrence of each character in the string
        last_occurrence = {char: i for i, char in enumerate(s)}
        
        # Initialize variables to track partitions
        partitions = []
        start, end = 0, 0
        
        # Step 2: Traverse the string to determine partitions
        for i, char in enumerate(s):
            # Update the end of the current partition to the last occurrence of the current character
            end = max(end, last_occurrence[char])
            
            # If the current index matches the end of the partition
            if i == end:
                # Add the size of the partition to the result
                partitions.append(end - start + 1)
                # Update the start of the next partition
                start = i + 1
        
        return partitions
