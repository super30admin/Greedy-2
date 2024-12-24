class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        last_occurence = {char: i for i, char in enumerate(s)}
        result = []
        start = 0
        end = 0

        for i, char in enumerate(s):
            end = max(end, last_occurence[char])
            if i == end:
                result.append(end - start + 1)
                start = end + 1
        return result

    # time complexity is O(2n)
    # space complexity is O(1)
