class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        map = {}

        for i in range(len(s)):
            c = s[i]
            map[c] = i

        result = []

        start = 0
        end = 0

        for i in range(len(s)):
            c = s[i]
            end = max(end, map[c])

            if i == end:
                result.append(end - start + 1)
                start = i + 1

        return result