'''
TC: O(n)
SC: O(n)
'''
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        if not s:
            return []
        
        slen = len(s)
        ret = list()
        hmap = dict()
        
        for i in range(slen):
            hmap[s[i]] = i
        
        prev = hmap[s[0]]
        start = 0
        
        for i in range(slen):
            if i >= prev:
                ret.append(prev - start + 1)
                if i == slen - 1:
                    break
                prev = hmap[s[i + 1]]
                start = i + 1
            if hmap[s[i]] > prev:
                prev = hmap[s[i]]
        
        return ret
        
        