#Time Complexity: O(n)
#Space Complexity: O(n)
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        res = []
        hmap = {}
        for i in range(len(s)):
            hmap[s[i]] = i
        start = 0
        end = 0
        
        for i in range(len(s)):
            end = max(hmap[s[i]],end)
            if i == end:
                res.append(end-start+1)
                start = end+1
            
        return res