# Approach: Greedy
# Store the last repeated position in the last_count array
# Using 2 pointers track the partition and go to new partition when the current pointer reaches end
# Time: O(n) + O(n); Space: O(1)
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        # O(1)
        last_count = {}
        res = []
        # Store the last repeated position in the last_count array
        for i in range(len(s)):
            last_count[s[i]] = i
        print(last_count)

        end = 0
        start = 0
        # Using 2 pointers track the partition and go to new partition when the current pointer reaches end
        for i in range(len(s)):
            end = max(end, last_count[s[i]])
            if i == end:
                length = (end - start + 1)
                res.append(length)
                start = i + 1
        return res











