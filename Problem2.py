"""
First, I store the last occurrence of each character using a list of size 26. Then, I use two pointers — `start` and `end` — to keep track of the current partition. As I loop through the string, I keep extending `end` to the farthest last index of characters I've seen. When the current index matches `end`, it means all characters in this range are self-contained, so I record the partition size. Then I move `start` to begin a new partition.
Time Complexity: O(n)
Space Complexity: O(1)
"""
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        last = [0] * 26
        for i, char in enumerate(s):
            last[ord(char) - ord('a')] = i

        result = []
        start = end = 0
        for i, char in enumerate(s):
            end = max(end, last[ord(char) - ord('a')])
            if i == end:
                result.append(end - start + 1)
                start = i + 1
        return result