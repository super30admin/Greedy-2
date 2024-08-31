#// Time Complexity : O(N) 
# // Space Complexity : O(1) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : No.

class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        dicti = defaultdict()
        for i in range(len(s)):
            dicti[s[i]] = i
        # print(dicti)
        result = []
        start = 0
        end = 0
        for i in range(len(s)):
            # print(s[i],dicti[s])
            end = max(end,dicti[s[i]])
            if i == end:
                result.append(end-start + 1)
                start = i + 1
        return result

# Approach:
# 1. Create a dictionary to store the last occurrence of each character in the string.
# 2. Initialize the start and end pointers to 0.
# 3. Iterate through the string. For each character, update the end pointer to be the maximum of
# the current end pointer and the last occurrence of the character in the dictionary.
# 4. If the current index is equal to the end pointer, it means we have found a partition
# 5. Append the length of the partition to the result list and update the start pointer to the next
# character.
# 6. Return the result list.
