# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        result = []
        if s == None or len(s) == 0:
            return result
        
        hashmap = {}
        for i in range(len(s)):
            hashmap[s[i]] = i
            
        start, end = 0, 0
        for i in range(len(s)):
            end = max(end, hashmap[s[i]])
            if i == end:
                result.append(end-start+1)
                start = end + 1
                
        return result
        