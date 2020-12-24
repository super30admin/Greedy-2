#Time Complexity : O(n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes

class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        endIndexes = dict()
        #get all last indexes of each character in the string
        for i in range(len(S)):
            endIndexes[S[i]] = i

        result = []
        end, start = 0, 0
        for i, char in enumerate(S):
            #update end depending on last index of each partition
            end = max(end, endIndexes[char])
            #if we've reached end of patition
            if end == i:
                result.append(end - start + 1)
                start = i + 1

        return result
