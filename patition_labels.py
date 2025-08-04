def partitionLabels(s):
    last_occurrence = {char: idx for idx, char in enumerate(s)}
    result = []
    anchor = 0
    max_idx = 0
    
    for idx, char in enumerate(s):
        max_idx = max(max_idx, last_occurrence[char])
        if idx == max_idx:
            result.append(idx - anchor + 1)
            anchor = idx + 1
    
    return result

# Time complexity: O(n)
# Space complexity: O(n)
