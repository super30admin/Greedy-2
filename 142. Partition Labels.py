class Solution:
    def partitionLabels(self, s):
        if s is None or len(s) == 0:
            return []

        n = len(s)
        hashMap = dict()
        li = []
        for i in range(n):
            hashMap[s[i]] = i

        start = 0
        end = 0

        for i in range(n):
            c = s[i]
            end = max(end, hashMap.get(c))
            if end == i:
                li.append((i - start) + 1)
                start = end + 1
        print(li)
        return li


s = "ababcbacadefegdehijhklij"

if __name__ == "__main__":
    obj = Solution()
    obj.partitionLabels(s)

# Greedy
# Time Complexity: O(n)
# Space Complexity: O(1) as maximum number of char can be 26
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
