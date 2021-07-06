class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        if s is None or len(s)==0:
            return []
        res = []
        start=0
        end=0
        char_map={}
        for i in range(len(s)):
            c=s[i]
            char_map[c]=i
        for i in range(len(s)):
            c=s[i]
            end=max(end,char_map[c])
            if end==i:
                res.append(end-start+1)
                start=i+1
        return res
        