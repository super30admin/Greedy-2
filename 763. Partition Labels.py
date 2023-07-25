#Time Complexity:O(n)
#Space Complexity:O(n)

class Solution(object):
    def partitionLabels(self, s):
        """
        :type s: str
        :rtype: List[int]
        """
        if len(s)==0:
            return []
        n=len(s)
        freq={}
        for i in range(n):
            freq[s[i]]=i
        start=0
        end=0
        result=[]
        for i in range(n):
            end=max(end,freq.get(s[i]))
            if i==end:
                result.append(end-start+1)
                start=end+1
        return result
