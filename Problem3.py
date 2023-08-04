class Solution(object):
    def partitionLabels(self, s):
        """
        Partition the string into as many parts as possible so that each letter appears in at most one part.

        Time complexity: O(n)
        Space complexity: O(1), because O(n) == O(26) ==> "O(1)"

        :type s: str
        :rtype: List[int]
        """
        result = []  # Initialize a list to store the partition sizes.
        # Create a hashmap to store the last occurrence index of each character.
        endIdxMap = {}

        for i in range(0, len(s)):
            c = s[i]
            # Update the last occurrence index of the character.
            endIdxMap[c] = i

        start = 0  # Initialize the start index of the current partition.
        end = 0    # Initialize the end index of the current partition.

        for i in range(0, len(s)):
            c = s[i]
            # Update the end index based on the last occurrence of the character.
            end = max(end, endIdxMap[c])

            if i == end:
                # Append the size of the current partition.
                result.append(end - start + 1)
                start = i + 1  # Update the start index for the next partition.

        return result  # Return the list of partition sizes.
