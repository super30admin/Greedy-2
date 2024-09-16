class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        # Time Complexity : O(n) where n is the length of the string
        # Space Complexity : O(1) because the size of the charList array is fixed doesn't matter what is the size of the input. It is always 26 in length so constant space, and also if we don't consider the length of the resultant array.
        charList = [None] * 26
        for index, value in enumerate(S):
            charList[ord(value) - ord("a")] = index
        res = []
        start, end = 0, 0
        for index, value in enumerate(S):
            end = max(end, charList[ord(value) - ord("a")])
            if end == index:
                res.append(end - start + 1)
                start = end + 1
        return res