# TimeComplexity:O(n)
# SpaceComplexity:O(1) .. 26/52 chars
# Approach:
# For each char get last  idx where char has appreared if idx == last_c then aadd it to ans other wise update last_c we do this greedly we just update end keeping start fixed 







class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        res = []

        last = {}
        for i, c in enumerate(s):
            last[c] = i

        start = 0
        last_c = 0
        for end in range(len(s)):
            last_c = max(last_c, last[s[end]])
            if last_c == end:
                res.append(end - start + 1)
                start = end + 1
        
        return res
