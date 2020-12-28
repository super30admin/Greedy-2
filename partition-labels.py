# Time Complexity: O(n)
# Space Complexity: O(n)

from collections import defaultdict
class Solution(object):
    def partitionLabels(self, S):
        """
        :type S: str
        :rtype: List[int]
        """
        from collections import defaultdict
class Solution(object):
    def partitionLabels(self, S):
        """
        :type S: str
        :rtype: List[int]
        """
        # Prepare a map of last occurances
        s_list = list(S)
        partition_map = defaultdict(int)
        partitions = []
        
        for i in range(len(s_list)):
            partition_map[s_list[i]] = i
                    
        start, end= 0,0
        for i in range(len(S)):
            # For every character, greedily pick the end index as last index at which it occurs
            c = S[i]
            end = max(end, partition_map[c])
            # When i meets end, update start to end + 1
            # This marks a new partition
            if i == end:
                partitions.append(end - start + 1)
                start = end + 1
            
        return partitions