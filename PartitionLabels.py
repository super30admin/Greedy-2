# Time Complexity: O(n) n is the length of the array
# Space Complexity: O(1)
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        if not s:
            return []
        
        last_index = {char: idx for idx, char in enumerate(s)}
        result = []
        
        start = 0
        end = last_index[s[0]]
        
        for i in range(len(s)):
            end = max(end, last_index[s[i]])
            if i == end:
                result.append(end - start + 1)
                start = i + 1
                
        return result