# Time complexity - O(n)
# Space complexity - O(1)

class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        hmap = defaultdict(int)
        for i,ch in enumerate(s):
            hmap[ch] = i
        
        start = end =0
        result = []
        for i,ch in enumerate(s):
            end = max(end, hmap[ch])
            if i == end:
                result.append(end - start + 1)
                start = end + 1
        return result
