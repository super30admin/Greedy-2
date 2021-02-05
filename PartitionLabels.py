"""
Approach:

Intuition

Let's try to repeatedly choose the smallest left-justified partition. Consider the first label, say it's 'a'. The first partition must include it, and also the last occurrence of 'a'. However, between those two occurrences of 'a', there could be other labels that make the minimum size of this partition bigger. For example, in "abccaddbeffe", the minimum first partition is "abccaddb". This gives us the idea for the algorithm: For each letter encountered, process the last occurrence of that letter, extending the current partition [anchor, j] appropriately.

Algorithm

We need an array last[char] -> index of S where char occurs last. Then, let anchor and j be the start and end of the current partition. If we are at a label that occurs last at some index after j, we'll extend the partition j = last[c]. If we are at the end of the partition (i == j) then we'll append a partition size to our answer, and set the start of our new partition to i+1.

TC: O(n)
SC: O(1)
"""

from collections import Counter
class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        if S == None or len(S) == 0:
            return []
        
        lastOccur = {}
        for i in range(len(S)):
            lastOccur[S[i]] = i
            
                
        start = 0
        end = 0
        result = []
        
        for i in range(len(S)):
            end = max(end, lastOccur[S[i]]) #8

            if i == end:
                result.append(end-start+1)
                start = end + 1

        return result