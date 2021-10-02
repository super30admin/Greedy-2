"""
Time Complexity : O(n) where n is the length of the string
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        if len(s) == 0:
            return []
        result = []
        hashMap = {}
        # Enter the last occurence of the letter in the hash map
        for i in range(len(s)):
            hashMap[s[i]] = i 
        start = 0
        end = 0
        # We travers through the string and then update maximum occurence index in 
        # the hashmap of the element that is already in we update the start and end  `       # pointers. Whenever we hit the index equals the end pointer we calculate the
        # diff end and start and append it to the resulting array and update the 
        # start equals end. 
        for i in range(len(s)):
            c = s[i]
            end = max(end, hashMap[c])
            if i == end:
                result.append(end - start + 1)
                start = end + 1
        return result
                