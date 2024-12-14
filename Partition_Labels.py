"""
Brute force: identify the last occurrence of each character. For example:
"ababcbacadefegdehijhklij"

find last occurrence of a, mark it as end. then find last occurrence of b. if it lies inside start and end then end
does not change. If it lies after the end, then update ends to it.
At each step we are trying to find the partition length by adding one. Thats why greedy.

Approach2: in the hmap store the last occurance of each ch.
"""

class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        hmap = {}
        ans = []
        for idx, ch in enumerate(s):
            if ch not in hmap:
                hmap[ch] = -1
            hmap[ch] = idx

        end = float("-inf")
        start = 0 # to find the length of the partition
        # iterate through the array and update end
        for curr_idx, ch in enumerate(s):
            end = max(end, hmap[ch])

            # now if curr idx reaches end that means obe partition is done
            # find the lenght and update the start to end+1
            if curr_idx == end:
                ans.append(end - start + 1)
                start = end +1

        return ans