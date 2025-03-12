class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        # T: O(n), S: O(1)
        # Dictionary to store the last occurrence of each character
        last_occurrence = {}
        for i, char in enumerate(s):
            last_occurrence[char] = i

        # Variables to track partitions
        partitions = []
        start = 0
        end = 0

        # Iterate through the string
        for i, char in enumerate(s):
            # Update the furthest endpoint for the current partition
            end = max(end, last_occurrence[char])

            # If we've reached the end of the current partition
            if i == end:
                # Add the size of this partition to our result
                partitions.append(end - start + 1)
                # Update the start for the next partition
                start = i + 1

        return partitions
