#time:O(n)
#space:O(n)
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        # create last index dict
        idx_dict= dict()
        for i in range(len(s)):
            idx_dict[s[i]]= i

        # start and end ptrs for measuring the sizes of partitions
        start=0
        end=idx_dict[s[0]]

        #partition array
        part_arr=list()
        #iterating again to check partitions
        for i in range(len(s)):
            end=max(idx_dict[s[i]],end)
            if i == end:
                part_arr.append(end-start+1)
                start= end+1

        return part_arr
