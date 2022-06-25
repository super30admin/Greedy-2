class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        hashmap={}
        for i in range(len(s)):
            hashmap[s[i]]=i
        output=[]
        start,end=0,0
        for i in range(len(s)):
            if s[i] in hashmap and hashmap[s[i]]>end:
                end = hashmap[s[i]]
            
            if i==end:
                output.append(end-start+1)
                start=end=end+1
            
        return output
                
                