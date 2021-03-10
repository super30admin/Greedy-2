#Time Complexity -- O(N)
#Space Complexity -- O(N)
class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        
        if not S:
            return []
        
        index = {}
        
        for i in range(len(S)):
            index[S[i]] = i
            
        curr = 0
        end = index.get(S[0])
        result = []
        start = 0
        
        for i in range(len(S)):
            curr = index.get(S[i])
            if curr > end:
                end = curr
            
            if i == end:
                result.append(end+1-start)
                start = end+1
                
        return result
