# TC: O(N)
# SC: O(N)

class Solution:
    def partitionLabels(self, s: str) -> List[int]:

        lastIndex={} #Here we are gonna store the character and it's index

        size=end=0
        res=[]
        for i,c in enumerate(s):
            lastIndex[c]=i
        
        #print(lastIndex)

        for i,c in enumerate(s):
            size+=1
            if lastIndex[c]>end:
                end=lastIndex[c]
            if i==end:
                res.append(size)
                size=0
        return res