'''
Time: O(n)
Space: O(n)
'''


class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        
        if s == '' or len(s) == 0:
            return list()
        
        hm = dict()
        
        for i in range(len(s)):
            hm[s[i]] = i
        
        print(hm,s)
        
        res = list()
        start,end = 0,0
        
        for i in range(len(s)):
            end = max(end, hm[s[i]])
            if i == end:
                res.append(end - start + 1)
                start = i + 1
        return res
            
            
            