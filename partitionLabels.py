class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        hmap=dict()
        # create hashmap of characters' starting and ending indices
        for idx, char in enumerate(s):
            if char not in hmap:
                hmap[char]=[idx, 0]
            hmap[char][1]=idx
        
        #sort them
        li=sorted(hmap.values())
        res=[]
        low=li[0][0]
        high=li[0][1]
        for ele in li:
            eStart=ele[0]
            eEnd=ele[1]

            if eStart>high:
                res.append(high-low+1)
                low=eStart
                high=eEnd
            
            if eStart>low and eEnd>high:
                high=eEnd
            
            
        res.append(high-low+1)
        return res

        