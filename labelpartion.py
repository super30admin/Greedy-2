#Time Complexity : O(N) where N is number of elemeents
#Space Complexity :O(N) where N is number of elemeents stored
class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        lastOccurringIndexMap = {}
        for i in range(len(S)):
            lastOccurringIndexMap[S[i]] = i
        start = 0
        end = 0
        finalPartitions = []
        for i in range(len(S)):
            end = max(end, lastOccurringIndexMap[S[i]])
            if (i == end):
                finalPartitions.append(end - start + 1)
                start = i + 1    
        return finalPartitions
