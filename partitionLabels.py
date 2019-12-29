#Leetcode : Pass
#TC- O(n), SC- O(1)
# 1) create hashmap with char,lastIndex
# 2) iterate over the array again to find the boundary char for a partition
# 3) when partition found append the length to output array
class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        map = {}
        #1
        for i in range(len(S)):
            map[S[i]] =i
        output=[]
        start =0
        end =0
        for i in range(len(S)):
            #2
            if end< map[S[i]]:end= map[S[i]]
            #3
            if i == end:
                output.append(end-start+1)
                start=end+1
        return output
