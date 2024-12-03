# Problem 3: Partition Labels
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        Map = {}
        result = []

        for i in range(len(s)):
            c = s[i]
            Map[c] = i

        start,end = 0,0
        for i in range(len(s)):
            c = s[i] 
            end = max(end,Map[c])
            if i == end: 
                result.append(end - start + 1)
                start = end + 1

        return result

        
        