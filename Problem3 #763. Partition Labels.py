# Time Complexity : O(N)
# Space Complexity : O(1)

class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        dic = dict()
        result = []
        
        for i in range(0, len(s)):
            dic.update({s[i] : i})
            
        start = 0
        end = 0
        for i in range(0, len(s)):
            ch = s[i]
            end = max(end, dic.get(ch))
            
            if i == end:
                result.append(end - start + 1)
                start = i + 1
        
        return result
