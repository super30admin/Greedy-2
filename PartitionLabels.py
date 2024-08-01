# Time Complexity : O(n)
# Space Complexity : O(1)
class Solution:
    def partitionLabels(self, s: str):
        if not s:
            return []

        start, end, n = 0, 0, len(s)
        index_map = {}
        result = []

        # Record the last occurrence of each character in the string
        for i in range(n):
            index_map[s[i]] = i

        for i in range(n):
            end = max(end, index_map[s[i]])  # Find the max ending index for each character in the substring
            if end == n - 1:  # The ending index is equal to the length of the string
                result.append(end - start + 1)
                return result
            if i == end:  # If we have reached the end
                result.append(end - start + 1)  # Add the substring length to result
                start = i + 1  # Update the start index

        return result

# Examples

# Example 1
s = "ababcbacadefegdehijhklij"
sol = Solution()
print(sol.partitionLabels(s))  # Output: [9, 7, 8]

# Example 2
s = "eccbbbbdec"
sol = Solution()
print(sol.partitionLabels(s))  # Output: [10]

# Example 3
s = "caedbdedda"
sol = Solution()
print(sol.partitionLabels(s))  # Output: [1, 9]