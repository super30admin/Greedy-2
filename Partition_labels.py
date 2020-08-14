--------------------------Partition Labels------------------------------------------
# Time Complexity : O(2N) as N is length of people 
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# We will have a last index of each and every char in the dictionary. And then iterate again with 2 pointers and 
# with start pointe at 0 and end pointer at last index of start char. With iterating through string and if the 
# end char of the start char is greater then end char,then change the end pointer to that index. if start equals
# to end then add window to the resultant array. and change the start and end pointers to next window.  
class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        if not S:
            return []
        
        d = {}
        for i in range(len(S)):
            d[S[i]] = i
        
        start = 0
        temp = 0
        res = []
        end = d[S[start]]
        while end <len(S):
            while end != start:
                if d[S[start]]>end:
                    end = d[S[start]]
                start +=1
            
            res.append(end-temp+1)
            if end <= len(S)-2:
                start = end+1
                temp = start
                end = d[S[start]]
            else:
                break
        return res