#Time Complexity - O(n)
#Space Complexity - O(n)
class Solution(object):
    def partitionLabels(self, S):
        """
        :type S: str
        :rtype: List[int]
        """
        d = dict()
        for i in range(len(S)):
            d[S[i]] = i
        i = 0
        start = 0
        right = -1
        ans = []
        while i < len(S):
            if d[S[i]] > right:
                right = d[S[i]]
            if i == right:
                diff = i - start + 1
                ans.append(diff)
                start = i + 1
            i = i + 1
        return(ans)
        