# TC:  O(n)
# SC : O(26) = O(1) for the hashmap
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        ans = []
        if not s:
            return ans

        h = {}
        
        for i in range(len(s)):
            if s[i] not in h.keys():
                h[s[i]] = 0
            h[s[i]] = i
        
        start = 0
        end = h[s[0]]
        for i in range(len(s)):
            end = max(end, h[s[i]])
            if i == end:
                ans.append(end-start+1)
                start = i + 1
        
        return ans