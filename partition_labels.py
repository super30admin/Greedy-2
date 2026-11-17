'''
763 Partition Labels
https://leetcode.com/problems/partition-labels/description/

You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part. For example, the string "ababcc" can be partitioned into ["abab", "cc"], but partitions such as ["aba", "bcc"] or ["ab", "ab", "cc"] are invalid.

Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

Return a list of integers representing the size of these parts.

Example 1:
Input: s = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.

Example 2:
Input: s = "eccbbbbdec"
Output: [10]

Constraints:
1 <= s.length <= 500
s consists of lowercase English letters.

"a b a b c b a c a  d e f e g d e   h i j h k l i j"
                  |               |

Solution:
1. Brute Force
Do a linear search to find the last occurrence of each char
for i in range(len(string)): # O(N)
    c = string[i]
    for j in range(i, len(string)) # O(N)
        if c == string[j]
           last_index[c] = j
https://youtu.be/6oieC_S17dc?t=3758
Time: O(N^2), Space: O(1)

2. Hash map
Instead of doing a linear search, we use a hash map.

First, we find the last position of every character in the string by traversing the string and storing the latest indices in a hash map.

Then while scanning the string again, we use a current index to read the current char and retrieve the last index of that character using a hash map. LEt the last index be = last

Then increment current index by 1 and read the next char. If the last index of that character < last, then do nothing. Else, update last = last index of that char.

When our current index reaches that last index, we have reached the end of the current partition. We cut a partition and continue from the next character in the string to build the next partition.

Time: O(N), Space: O(1)

https://youtu.be/6oieC_S17dc?t=4398 (RK)
https://youtu.be/jQco2C4_DdY?t=3519 (JS)


'''
from collections import defaultdict

# works
# def partitionLabels(s):
#     if not s:
#         return []
#     N = len(s)
#     h = defaultdict(int)
#     # find out the posn of the last occurrence of each char
#     for i in range(N):
#         c = s[i]
#         h[c] = i

#     result = []
#     start, end = 0, 0
#     for i in range(N):
#         c = s[i]
#         end = max(end, h[c])
#         if i == end:
#             result.append(end-start+1)
#             start = end + 1
#     return result

def partitionLabels(s):
    if not s:
        return []
    N = len(s)
    h = defaultdict(int)
    # find out the posn of the last occurrence of each char
    for i in range(N):
        c = s[i]
        h[c] = i

    result = []
    start = 0
    partition_end = h[s[start]]
    for i in range(N):
        c = s[i]
        if i == partition_end:
            # result.append([start, partition_end]) # track partition indices
            result.append(partition_end-start+1)
            start = partition_end + 1
            if start <= N-1:
                partition_end = h[s[start]]
        partition_end = max(h[c], partition_end)
    return result


def run_tests():
    tests = [("ababcbacadefegdehijhklij", [9,7,8]),
             ("eccbbbbdec", [10]),
    ]
    for test in tests:
        s, ans = test[0], test[1]
        result = partitionLabels(s)
        print(f"\nstring = {s}")
        print(f"partitions - {result}")
        passed = (ans == result)
        assert passed == True, f"Test case failed"
        print(f"Pass: {passed}")
    print(f"\nDONE")

run_tests()