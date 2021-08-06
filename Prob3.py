class Solution(object):
    def partitionLabels(self, s):
        """
        :type s: str
        :rtype: List[int]
        """
        #O(n) time and constant space
        result = []
        last_map = {}
        
        for i in xrange(len(s)):
            last_map[s[i]] = i
        
        start,end = 0,0
        
        #make partitions
        
        for i in xrange(0,len(s)):
            ch = s[i]
            end = max(end,last_map[ch])
            if i == end:
                result.append(end - start + 1)
                start = end + 1
        return result
