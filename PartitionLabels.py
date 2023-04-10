"""
Rasika Sasturkar
Time Complexity: O(2n) = O(n)
Space Complexity: O(1)
"""


def partitionLabels(s: str):
    result = []
    # null case
    if s is None:
        return result

    char_map = {}

    for i in range(len(s)):
        char = s[i]
        char_map[char] = i

    start, end = 0, 0

    for i in range(len(s)):
        char = s[i]
        end = max(end, char_map[char])
        if i == end:
            result.append(end - start + 1)
            start = i + 1

    return result


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all the test cases.
    """
    print(partitionLabels(s="ababcbacadefegdehijhklij"))  # returns [9, 7, 8]
    print(partitionLabels(s="eccbbbbdec"))  # returns [10]


if __name__ == "__main__":
    main()
