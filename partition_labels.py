# Time - O(N)
# Space - O(1)
# approach - maintain a map of characters and partition based on where we last saw the char
class Solution:
    def partitionLabels(self, S: str) -> List[int]:
       

        lastSeen = {}  # O(1) constant map with 26 chars
        for i in range(len(S)):
            lastSeen[S[i]] = i

        result = []
        start = end = 0

        for i in range(len(S)):
            end = max(end, lastSeen[S[i]])
            if i == end:
                result.append(end - start + 1)
                start = end + 1

        return result