class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        # T.C. = O(n)
        # S.C. = O(1) since we have limited constants that we can put in the dictionary
        # Here we first mark the end of all characters in the ends array
        # then we go over the string and check if the end of current character exceeds
        # the defined partition end, if so we update the high/end
        # once the current passes the high it indicates that we have registered our end of
        # parition
        # then we update the low and high to begin the next partition
        if((s is None) or (len(s)==0)):
            return []

        size = len(s)
        ends = dict()

        for i in range(size):
            ends[s[i]] = i

        result = list()

        # Option 1:
        low = high = 0
        while low < size:
            curr = low
            while curr<=high:
        # --
        #         if ends[s[curr]] > high:
        #             high = ends[s[curr]]
        # --
        # or
                high = max(high,ends[s[curr]])
                curr+=1
            result.append(high-low+1)
            low = high = curr

        # Option 2:
        # start = end = 0
        # for i in range(size):
        #     char = s[i]
        #     end = max(ends[char],end)

        #     if i==end:
        #         result.append(end-start+1)
        #         start = i + 1

        return result