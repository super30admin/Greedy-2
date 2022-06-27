class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        hm = dict()
        for i,v in enumerate(s):
            hm[v] = i
        
        st = 0
        end=0
        res = []
        for i,v in enumerate(s):
            end = max(hm[v],end)
            if(i==end):
                res.append(end-st+1)
                st=end+1
        return res