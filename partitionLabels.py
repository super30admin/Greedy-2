import collections

#timeComplexity: O(N)
#space Complexity : O(n)

def partitionLabels(self, s: str) -> List[int]:
    if not s:
        return []
    lastOccurance = collections.defaultdict(int)
    result = []
    for idx, val in enumerate(s):
        lastOccurance[val] = idx

    # print(lastOccurance)

    l = 0
    while l < len(s):
        start = l
        end = lastOccurance[s[l]]
        while l <= end:
            if lastOccurance[s[l]] <= end:
                l += 1
            else:
                end = lastOccurance[s[l]]
        result.append(end - start + 1)
    return result