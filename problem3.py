#Time O(n), space O(1)
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        
        m={}
        p=[]
        end=0
        start=0
        #Traversing and adding the last occurence of character's indices to the hashmap
        for i in range(len(s)):
            m[s[i]]=i

    #Updating end and start and checking the partitions        
        for i in range(len(s)):
            c=s[i]
            if m[c]>end:
                end = m[c]
                
            if end == i:
                p.append(end-start+1)
                start=i+1
                
        return p
