# time complexity is o(n), where n is the size of the input
# space complexity is o(n), where n is the size of the input
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        res = list()
        d = dict()
        for i in range(len(s)):
            if(i not in d):
                d[s[i]] = i
            d[s[i]] = i
        start = 0
        end = d[s[0]]
        for i in range(len(s)):
            end = max(d[s[i]], end)
            if(i == end):
                res.append(end - start + 1)
                start = end+1
        return res
                

            
        