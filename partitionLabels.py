"""
First, record the last index where each character appears
While iterating through the string, track the farthest last occurrence of any character seen so far
When the current index reaches that farthest point, we've found a valid partition
"""
"""
Time Complexity : O(n)	One pass through string
Space Complexity: O(1)	Last index map has ≤26 letters
"""

class partitionLabels:
    def partitionLabel(self, s: str) -> list[int]:
        last = {char: i for i, char in enumerate(s)}
        result = []
        start = end = 0

        for i, char in enumerate(s):
            end = max(end, last[char])
            if i == end:
                result.append(end - start + 1)
                start = i + 1

        return result
    
if __name__ == "__main__":
    obj = partitionLabels()
    print(obj.partitionLabel("ababcbacadefegdehijhklij")) 
    print(obj.partitionLabel("eccbbbbdec")) 
    print(obj.partitionLabel("abc"))  
