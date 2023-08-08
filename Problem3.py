'''
Problem: Partition Labels
Time Complexity: O(n), where n is given elements
Space Complexity: O(1)
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        add last index of character in the dictionary
        traverse the input string and add to the partition if i == end index       
'''

class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        dicts={}
        for i in range(len(s)):
            dicts[s[i]] = i
        
        result = []

        start = 0
        end = 0

        for i in range(len(s)):
            end = max(end, dicts.get(s[i]))
            if i == end:
                result.append(end - start + 1)
                start = i + 1

        return result
