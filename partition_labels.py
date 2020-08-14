class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        hashmap = {}
        start, end = 0, 0
        result = []
        for i, j in enumerate(S):
            hashmap[j] = i
        for index, val in enumerate(S):
            end = max(end, hashmap[val])
            if index==end:
                result.append(end-start+1)
                start=index+1
        return result

#time complexity - O(2n)

#space complexity - O(1)

#all test cases passed