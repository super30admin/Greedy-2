# Time Complexity : O(n)
# Space Complexity : O(1)

class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        out = []
        hashmap = defaultdict(int)
        for i in range(len(s)):
            hashmap[s[i]] = i
        start = end = 0
        for i in range(len(s)):
            char = s[i]
            end = max(end, hashmap[char])
            if i == end:
                out.append(end-start+1)
                start = end + 1
        return out

#         a b a b c b a c a d  e f  e  g  d  e  h  i  j  h  k  l  i  j
#         | |   | | |   | |
#         0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23

#         a - 0 -> 8
#         b - 1 -> 5
#         c - 4 -> 7
#         d - 9 -> 14
#         e - 10 -> 15
#         f - 11 -> 11
#         g - 13 -> 13
#         h - 16 -> 19
#         i - 17 -> 22
#         j - 18 -> 23
#         k - 20 -> 20
#         l - 21 -> 21
