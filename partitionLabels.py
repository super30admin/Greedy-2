class Solution:
    # greedy 2 pointers
    # TC : O(n)
    # SC : O(1)
    def partitionLabels(self, s: str) -> List[int]:
        if s is None:
            return []
        res = []
        hmap = defaultdict(int)
        for i in range(len(s)):
            hmap[s[i]] = i
        start,end = 0,0
        for i in range(len(s)):
            c = s[i]
            end = max(end,hmap[c])
            if i == end:
                res.append(end-start+1)
                start = end +1
        return res
        