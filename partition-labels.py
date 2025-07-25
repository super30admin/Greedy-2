'''
Time Complexity: O(n)
Space Complexity: O(1) - because the lastIndexMap will have at most 26 characters

Approach: 
1. Create a last index map to store the last index of each character.
2. Initialize start and end pointers to 0.
3. Iterate through the string and update the end pointer to the last index of the current character.
4. If the current index is equal to the end pointer, append the length of the current partition to the result list.
5. Return the result list.
'''
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        lastIndexMap = defaultdict(int)
        N = len(s)
        for i in range(len(s)):
            lastIndexMap[s[i]] = i

        start = 0
        end = lastIndexMap[s[0]]
        res = []

        for i in range(len(s)):
            if lastIndexMap[s[i]] > end:
                end = lastIndexMap[s[i]]

            if i == end:
                res.append((end - start + 1))
                if i != N - 1:
                    start = i + 1
                    end = lastIndexMap[s[i + 1]]

        return res
