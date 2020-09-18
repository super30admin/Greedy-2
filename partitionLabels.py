# Leetcode 763. Partition Labels

# Time Complexity :  O(n) where n is the size of the string

# Space Complexity : O(1)

# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Map the last occurence of all characters. Iterating over the string with start and end pointer for
# each partition, check if the last occurence of the every char in the window is within end of the window 
# else update end of window to the last occurence of the character. Once the last occurence of all the characters
# in the window are inside the window calculate length of the window and add to result

# Your code here along with comments explaining your approach

class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        result = []
        if not S or len(S) == 0:
            return result
        # last position map of all characters
        lastPos = dict()
        for i in range(len(S)):
            char = S[i]
            lastPos[char] = i
            
        start = 0
        end = 0
        for i in range(len(S)):
            char = S[i]
            # moving end if the last position of character is out of the window length
            end = max(end,lastPos[char])
            # if reached end of window and last position of all characters falls in window
            if i == end:
                # length of partition to result array
                result.append(end-start+1)
                # move start to the begining of next partition
                start = end + 1
                   
        return result 