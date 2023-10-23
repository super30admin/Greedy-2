"""
Problem : 3

Time Complexity : O(n)
Space Complexity : O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


if start of next letter is out of bounds
put previous range in result
and update start and end to next letter

"""

# Partition Labels

class Solution(object):
    def partitionLabels(self, s):
        """
        :type s: str
        :rtype: List[int]
        """
        hmap={}
        for i in range(len(s)):
            ch=s[i]
            if ch not in hmap:
                hmap[ch]=[i,0]
            hmap[ch][1]=i
        partArr=hmap.values()
        partArr.sort(key=lambda x:x[0])
        start=partArr[0][0]
        end=partArr[0][1]
        result=[]
        for i in range(len(partArr)):
            part=partArr[i]
            if part[0]>end:
                result.append(end-start+1)
                start=part[0]
                end=part[1]
            elif part[0]<end:
                end=max(end,part[1])
                start=min(start,part[0])
        result.append(end-start+1)
        return result