
#Time Complexity : O(n)
#Space Complexity : O(1)

class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        d = dict()
        result = []

        for i in range(0, len(s)):
            d.update({s[i] : i})

        #print(d)
        start = 0
        end = 0
        for i in range(0, len(s)):
            ch = s[i]
            end = max(end, d.get(ch))

            if i == end:
                result.append(end - start + 1)
                start = i + 1

        return result