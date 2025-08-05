#Time Complexity: O(n)
#Space Complexity: O(n)
class Solution(object):
    def partitionLabels(self, s):
        """
        :type s: str
        :rtype: List[int]
        """
        last_occurance = {ch : i for i,ch in enumerate(s)}
        res = []
        start = end = 0

        for i,ch in enumerate(s):
            end = max(end,last_occurance[ch])

            if i == end:
                res.append(end - start + 1)
                start = i + 1
            
        return res

        