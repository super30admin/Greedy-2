# Time Complexity : T(n), Where n is the number of elements in the s string 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing Specific

from typing import List

class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        n=len(s)
        res=[]
        #Pre Processing
        hashmap={} 
        for i in range(n):
            if(s[i] in hashmap):
                #If it is in hashmap, Then update the value to the index
                hashmap[s[i]]=i
            else:
                #If it is not in hasmap, Then create an key, value pair with that index
                hashmap[s[i]]=i
        
        start,end=0,0
        for i in range(n):
            if(hashmap[s[i]]>end):
                #Update the end
                end=hashmap[s[i]]

            if(i==end):
                #Calculate the length of the Partition, As we reached the end of the partition
                res.append(end-start+1)
                #Update the start and end
                start,end=i+1,i+1
        return res