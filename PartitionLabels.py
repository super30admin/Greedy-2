'''
Solution:
1.  Maintain a HashMap to store the last occurence of any character in the input string S.
2.  For each chunk starting with first char, mark the highest possible end index using last occurence
    HashMap information, and update this end index as long as our cursor reaches end index.
3.  Repeat this process for every chunk to get all partitions while iterating the cursor continuously
    till the last character.

Time Complexity:    O(N)    |   Space Complexity:   O(1)
--- Passed all testcases successfully on leetcode.
'''


class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        
        lastOccurringIndexMap = {}
        
        #   fill the HashMap with last occurrences
        for i in range(len(S)):
            lastOccurringIndexMap[S[i]] = i
         
        #   initializations   
        start = 0
        end = 0
        finalPartitions = []
        
        #   for each character in string, update end
        #   whenever cursor reaches end => add it to partitions array and update start immediately
        for i in range(len(S)):
            
            end = max(end, lastOccurringIndexMap[S[i]])
            
            if (i == end):
                finalPartitions.append(end - start + 1)
                start = i + 1
        
        #   return the final partitions array.        
        return finalPartitions