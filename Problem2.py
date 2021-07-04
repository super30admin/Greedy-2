# Time Complexity: O (n)(Where n is length of string) 
# Space Complexity: O(1) (We have only a to z character)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# greedy approach can be used here

class Solution:
    def partitionLabels(self, S: str) -> List[int]:
#       Take dictionary to store last occurence of each character.
        last_index = {}
#       Store last index for every charcater
        for i in range(len(S)):
            last_index[S[i]] = i
            
#       Initialize partition start and end.
        start, end = 0, 0
        ans = []
        
#       Iterate through every character and extend end to the max of current and last index of the character. Because we want to cover all the occurence of chacter in the same partition.
        for i in range(len(S)):
            end = max(end, last_index[S[i]])
#           If index reach the end, add window size from start to end. Also update the start after end.
            if i == end:
                ans.append(end - start + 1)
                start = end + 1
        return ans
