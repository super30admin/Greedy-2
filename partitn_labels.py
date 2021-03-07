# Time Complexity : O(n)
# Space Complexity : O(1) (since only 26 chars)

class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        if not S: return [0]
        n = len(S)
        result = []
        
        hashmap = {}
        for i in range(n):
            hashmap[S[i]] = i
        
        start = 0
        end = hashmap[S[0]]
        for i in range(n):
            end_idx = hashmap[S[i]]
            end = max(end, end_idx)
                
            if i == end:
                result.append(end - start + 1)
                start = end + 1
        
        return result