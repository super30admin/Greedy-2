# Time Complexity : O(n)
# Space Complexity : O(1)
# Code ran on LeetCode
# Hash map of end indices of a character. Iterate over the string and keep updating the current span by updating the end indices whenever necessary

class Solution:
    def partitionLabels(self, s: str) -> List[int]:

        hash_map = {}
        for i in range(len(s)):
            hash_map[s[i]] = i
        i = 0
        res = []
        while i < len(s):
            start = i
            end = hash_map[s[i]]
            while i < len(s) and i <= end:
                if hash_map[s[i]] > end:
                    end = hash_map[s[i]]
                i += 1
            res.append(end - start + 1)
        return res
