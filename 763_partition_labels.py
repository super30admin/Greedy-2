"""

## Problem 763: Partition Labels

## Author: Neha Doiphode
## Date:   11-09-2022

## Description:
    You are given a string s. We want to partition the string into as many parts as possible,
    so that each letter appears in at most one part.

    Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

    Return a list of integers representing the size of these parts.

## Examples:
    Example 1:
        Input: s = "ababcbacadefegdehijhklij"
        Output: [9,7,8]
        Explanation:
                    The partition is "ababcbaca", "defegde", "hijhklij".
                    This is a partition so that each letter appears in at most one part.
                    A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.

    Example 2:
        Input: s = "eccbbbbdec"
        Output: [10]

## Constraints:
    1 <= s.length <= 500
    s consists of lowercase English letters.

## Time Complexity: O(N), where N is the length of string s.

## Space Complexity: O(1), to keep dictionary of last indices keys will be not more than 26 characters.

"""

from typing import List, Optional
from collections import OrderedDict

def get_input():
    print("Enter the string: ", end = "")
    string = input()
    return string

class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        result = []
        last_index_dict = OrderedDict()
        for char in s:
            if char not in last_index_dict:
                last_index_dict[char] = s.rindex(char)

        # "ababcbacadefegdehijhklij"
        start = 0
        end   = 0
        for index, char in enumerate(s):
            if last_index_dict[char] > end:
                end = last_index_dict[char]

            if index == end:
                result.append(end - start + 1)
                start = end + 1
        return result

# Driver code
solution = Solution()
string = get_input()
print(f"Input string: {string}")
print(f"Output list of size of partitions: {solution.partitionLabels(string)}")
