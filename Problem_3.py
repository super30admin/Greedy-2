"""
Time Complexity : O(2n)- n for making a dictionary and another n for traversing though and calculating
Space Complexity : O(1)- as result is just auxillary space and dictionary can have maximum 26 chars
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
Here, we will first build a dictionary with last occurances of all the characters. We can then start from the 
very first character and check when does it occur last. We will traverse till the last position and if 
in between, any other character's last index is beyond pur last index, we will update our end pointer.
When we finally reach end, we will update our result and start traversing with the new character from 
a new start.
"""


class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        d = {}
        l = len(S)
        result = []
        for i in range(l):
            d[S[i]] = i
        start = 0
        end = 0
        for i in range(l):
            end = max(end, d[S[i]])
            if i == end:
                result.append(i-start+1)
                start = i+1
        return result
