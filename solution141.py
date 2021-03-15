#Time Complexity:O(n)
#Space Complexity:O(n)
class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        result=[]
        if not S:
            return result
        dict={}                                     #use hash map to store each unique character and its last index
        for elem in list(set(S)):
            dict[elem]=S.rfind(elem)
        start=0                                     #use start and end variables to store the window of partition.
        end=0
        for i in range(len(S)):
            ch=S[i]
            end=max(end,dict[ch])
            if i==end:                              #when end is encountered append the widow size to the result and update start brfor returning result
                result.append(end-start+1)
                start=i+1
        return result