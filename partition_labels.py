# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I store the last index for each element. Then I start a window from the first element in index, updating each time the current max index
# when I reach a max index, I make a parition and and reset max to -1 and count to 0

class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        maxi = -1
        count = 0
        result = []
        mapping = defaultdict(lambda: 0)
        for i in range(len(S)):
            mapping[S[i]] = i
            
        for i in range(len(S)):
            count += 1
            maxi = max(maxi, mapping[S[i]])
            if i == maxi:
                result.append(count)
                maxi = -1
                count = 0
            
        return result
