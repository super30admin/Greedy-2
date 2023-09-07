#Time Complexity :O(n) 
#Space Complexity :O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        arr=[0]*26
        result=[]
        for i in range(len(s)):
            arr[ord(s[i])-ord('a')]=i

        start=0
        end=0
        for i in range(len(s)):
            c=s[i]
            end=max(end,arr[ord(s[i])-ord('a')])
            if i==end:
                result.append(end-start+1)
                start=end+1
        
        return result

        