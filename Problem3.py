# Problem 3 : Partition Labels
# Time Complexity : O(n) where n is the size of the s string
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        # array to store the last index of the character in the string s
        lastOccurrence = [0] * 26
        # result array to store the size of each partition
        result = []

        # loop through s string to get the last index of character ch
        for i, ch in enumerate(s):
            # store the index of the character ch at chth position 
            lastOccurrence[ord(ch) - ord('a')] = i

        # define start and end ie start and end position of partition to 0
        start = 0
        end = 0
        # loop through s string
        for i, ch in enumerate(s):
            # get the value of end position of partition as maximum value between end and last index of character ch 
            end = max(end, lastOccurrence[ord(ch) - ord('a')])
            # if the i is equal to end then it means we have reach the end of the current partition
            if i == end:
                # store the size of the partition (end - start + 1) in the result
                result.append(end - start + 1)
                # update start to i + 1 which is start of next partition
                start = i + 1
        # return the result array
        return result 
