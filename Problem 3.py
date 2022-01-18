# Time: O(n)
# Space: O(1)
class Solution(object):
    def partitionLabels(self, s):
        """
        :type s: str
        :rtype: List[int]
        """
        dic_end = {}
        #dic_start = {}
        for i in range(len(s)):
            if s[i] not in dic_end:
                #dic_start[s[i]] = i
                dic_end[s[i]] = i
            else:
                dic_end[s[i]] = i
        mx = -100000007
        ans = []
        prev = 0
        for i in range(len(s)):
            mx = max(mx, dic_end[s[i]])
            if mx <= i:
                ans.append(i+1-prev)
                prev = i+1
        return ans
                
            
        
