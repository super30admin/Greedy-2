#In this problem, we store last index of the character in map and at forst the end will be the last index of first character. Then, we set the end as end index of each character in the window.
#Time Complexity: O(n)
#Space Complexity: O(number of paritions)
class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        result = list()
        if S is None or len(S)==0:
            return []
        map = dict()
        for i in range(len(S)):
            c = S[i]
            map[S[i]] = i
        start = 0
        end = 0
        for i in range(len(S)):
            c = S[i]
            end = max(end,map[c])
            if end == i:
                result.append(end-start+1)
                start = end + 1
        return result