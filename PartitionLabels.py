class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        """Greedy Approach
        Time complexity-O(n)
        Space complexity-O(1) as we can have only at max 26 chars in hashmap"""
        hashmap={}
        arr=[]
        for i in range(len(s)):
            if s[i] not in hashmap:
                hashmap[s[i]]=0
            hashmap[s[i]]=i
        # print(hashmap)
        start=0
        end=0
        for i in range(len(s)):
            char=s[i]
            end=max(end,hashmap[char])
            if i==end:
                arr.append(end-start+1)
                start=end+1
        return arr
                
            
            
        