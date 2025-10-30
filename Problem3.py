"""
TC: O(N) {We traverse the string twice — once to record the last occurrence of each character 
           and once more to form partitions. Each operation within the loops is constant time, 
           resulting in an overall linear time complexity.}
SC: O(1) {We use a fixed-size array of length 26 to store the last occurrence index for each lowercase letter, 
           along with a few integer variables and a result list. Since the alphabet size is constant, 
           the auxiliary space usage is constant.}

Approach:
We are tasked with partitioning a string into as many parts as possible such that each letter appears 
in at most one partition. The goal is to return the sizes of these partitions.

We first precompute the last occurrence index of every character in the string using an array of size 26. 
This allows us to know how far each character needs to extend within a partition.

Next, we iterate through the string while maintaining:
    - `idx`: the farthest last occurrence index of any character seen so far.
    - `curr_sum`: the cumulative length of all partitions processed so far.

As we traverse the string:
    - For each character, we update `idx` to ensure that all characters in the current partition 
      are included up to their last appearance.
    - When the current index `i` equals `idx`, it means the partition can safely end here, 
      as all characters in this segment are self-contained. We then compute the partition size 
      (`i - curr_sum + 1`), append it to the result list, and move the partition boundary forward.

This greedy approach ensures each partition is as small as possible while maintaining the validity constraint 
that no character crosses partition boundaries.

This problem ran successfully on Leetcode.
"""

class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        #pre construct
        max_idx = [0]*26
        for i in range(len(s)):
            max_idx[ord(s[i]) - ord('a')] = max(max_idx[ord(s[i]) - ord('a')], i)
        
        res = []
        curr_sum = 0

        i = 0
        idx = 0

        while i < len(s):
            idx = max(idx, max_idx[ord(s[i]) - ord('a')])

            if i == idx:
                val = i - curr_sum + 1
                res.append(val)
                curr_sum += val

            i += 1

        return res        