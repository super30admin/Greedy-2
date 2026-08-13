# Problem3:Partition Labels (https://leetcode.com/problems/partition-labels/)
# Time Complexity: O(n),We loop through the string s two times, once to build the last index map and once to build the partitions. 
# Each loop runs n times where n is the length of s, so total work is O(n) + O(n) which simplifies to O(n).
# Space Complexity: O(1),The map can hold at most 26 keys since s only has lowercase English letters, so its size does not grow with the size of the input.
# Approach:
# First, we scan the string once and record the last index at which every character appears, using a dictionary.
# Then we scan the string a second time and for each character we expand our current window end to reach at least the last occurrence of that character. 
# This guarantees the current partition will not split any repeated character across two parts.
# When our current index i catches up to end, it means every character seen so far in this window has all its repeats accounted for, so we can close the partition here and start a new one right after.

from typing import List


class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        map = {}            # dictionary to store the last seen index of every character

        for i in range(len(s)):             # loop through every index of the string
            char = s[i]                     # get the character at the current index
            map[char] = i                   # store or update this character's last seen index

        result = []                     # will hold the size of each partition we find

        start = 0                        # marks the starting index of the current partition
        end = 0                          # marks the farthest index the current partition must reach

        for i in range(len(s)):             # loop through every index of the string again
            char = s[i]                     # get the character at the current index
            end = max(end, map[char])       # extend end if this character repeats further ahead

            if i == end:                              # current index has caught up to the farthest required point
                result.append(end - start + 1)       # partition size is end minus start plus one
                start = i + 1                       # next partition begins right after this one

        return result                           # send back the list of partition sizes