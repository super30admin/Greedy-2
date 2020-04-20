'''
Iterative:
Time Complexity: O(n)
Space Complexity: O(1)
Did this code successfully run on Leetcode : Yes
Explanation: Find the last occurance of each character in a frequency array. For every character we see set the end
pointer to the index of the last occurance of the character. If our cursor reaches this end then we reached one partition
end and the size is end-start+1, increase the start now to the cursor +1
'''
class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        res = []

        lastIndex = [0 for i in range(26)]

        for i in range(len(S)):
            ch = S[i]
            lastIndex[ord(ch) - ord('a')] = i

        start = 0
        end = 0

        for cursor in range(len(S)):
            ch = S[cursor]

            end = max(end, lastIndex[ord(ch) - ord('a')])

            # end of partition
            if cursor == end:
                # record partition
                partition = end - start + 1
                res.append(partition)
                start = cursor + 1

        return res

