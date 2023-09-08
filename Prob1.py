#O(n) TC and O(1) SC

class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        #get last occurence index and store in hashmap for each character
        h={}
        for i in range(len(s)):
            c=s[i]
            h[c]=i
        end=start=0
        res=[]

        #then, iterate and get the highest last occurence value from hashmap for each character you see, if you hit the highest last value, this is the end of current partition, so add it to res. Then, satrt new partition.
        for i in range(len(s)):
            c=s[i]
            end=max(end,h[c])
            if i==end:
                res.append(end-start+1)
                start=i+1
        return res
