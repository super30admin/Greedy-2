# Greedy
# TC: O(N)
# SC: O(26)~O(1)

class Solution:
    def partitionLabels(self, S: str):
        
        start = 0
        end = 0
        ans = []
        hmap = {}
        for i in range(len(S)):
            hmap[S[i]] = i
        
        for i in range(len(S)):
            end = max(end,hmap[S[i]])
            if i==end:
                ans.append(end-start+1)
                start = i+1
        return ans