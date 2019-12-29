'''
Accepted on leetcode(763)
time - O(N)
space - O(N)
Approach:
1. Create a hashmap with key as the letter and value the lastindex of its appearance in the string.
2. initialize start and end pointer. Declare a output array.
3. Iterate thought he string and change the partition end each time a new end is encountered until the end is equal to the iterator.
4. then add the partition size encountered to the output and change the start to next index.
'''


class Solution:
    def partitionLabels(self, S: str):
        hashmap = {}

        # to create an hashmap having value as lastindex of that element.
        for i in range(len(S)):
            hashmap[S[i]] = i

        start = 0
        end = 0
        output = []

        for i in range(len(S)):
            ch = S[i]

            end = max(end, hashmap[ch])  # calculate last element of each partition
            if end == i:  # if partition end is reached, append it to output and start new partition.
                output.append(end - start + 1)
                start = i + 1
        return output
