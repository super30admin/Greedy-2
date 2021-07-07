'''
763. Partition Labels - https://leetcode.com/problems/partition-labels/

Time complexity - O(N)
space complexity - O(N)

A particular alphabet should appear in only one partition 
Appraoch - Two pointers 
          1) First we create Hashmap of last index of every alphabet
          2) At every index end is equal max(end, hashmap value)
          3) then start becomes end+1
          4) then we partition only when end is equal to last index of the alphabet.
'''
          
class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        
        start=0
        end=0
        
        #storing last index of each alphabet
        hash={}
        for i,v in enumerate(S):
            hash[v]=i
            
        res=[]
        for i in range(len(S)):
            end=max(end,hash[S[i]]) # last element of every partition
            
            if end ==i:
                res.append(end-start+1) # we reached end of the partition
                start=end+1
        return res
            
        