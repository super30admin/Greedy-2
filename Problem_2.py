'''
406 Queue Reconstruction by Height
https://leetcode.com/problems/queue-reconstruction-by-height/description/

You are given an array of people, people, which are the attributes of some people in a queue (not necessarily in order). Each people[i] = [hi, ki] represents the ith person of height hi with exactly ki other people in front who have a height greater than or equal to hi.

Reconstruct and return the queue that is represented by the input array people. The returned queue should be formatted as an array queue, where queue[j] = [hj, kj] is the attributes of the jth person in the queue (queue[0] is the person at the front of the queue).

Example 1:
Input: people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
Explanation:
Person 0 has height 5 with no other people taller or the same height in front.
Person 1 has height 7 with no other people taller or the same height in front.
Person 2 has height 5 with two persons taller or the same height in front, which is person 0 and 1.
Person 3 has height 6 with one person taller or the same height in front, which is person 1.
Person 4 has height 4 with four people taller or the same height in front, which are people 0, 1, 2, and 3.
Person 5 has height 7 with one person taller or the same height in front, which is person 1.
Hence [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] is the reconstructed queue.

Example 2:
Input: people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
Output: [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]

Constraints:
1 <= people.length <= 2000
0 <= h_i <= 10^6
0 <= k_i < people.length
It is guaranteed that the queue can be reconstructed.

1. Sort and queue
Sort the elements (ele = [hi, ki]) first by descending order of hi (heights). Given the sorted elements, sort once again by ascending order of ki (no. of people in front). But why?
Consider A=[7,1], B=[7,0], C=[6,0]. Sorting this by descending hi and ascending ki, we get B=[7,0], A=[7,1], C=[6,0]. Now, in the case of tie between heights of A and B, we put B first and then A because this satisifes the property of ki. With [A, B], we have 0 persons ahead of A with height >= 7 and 1 person ahead of B with height >= 7 (which is A). See https://youtu.be/zx_64qoVVho?t=4123

Then for each person in the sorted array, we read the person's ki and insert it at index = ki in the result. Since taller people are already placed, inserting at index (ki) ensures everyone sees exactly the number of taller or equal people they expected.

Example:
input = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
sorted = [[7, 0], [7, 1], [6, 1], [5, 0], [5, 2], [4, 4]]
result = []
ele = sorted[0] -> index = 0 -> result = [7,0]
ele = sorted[1] -> index = 1 -> result = [[7,0], [7,1]]
ele = sorted[2] -> index = 1 -> result = [[7,0], [6,1], [7,1]]
ele = sorted[3] -> index = 0 -> result = [[5,0], [7,0], [6,1], [7,1]]
...


Another way to visualize this is this:
First sort based on height and save <heigt, list> in a map
7 -> [7,0], [7,1]
6 -> [6,1]
5 -> [5,0], [5,2]
4 -> [4,4]

Now add to the values to the result list starting from highest to lowest height in the map
result = [7,0]
result = [[7,0], [7,1]]
result = [[7,0], [6,1], [7,1]]  (ele = [6,1], i = ele[1], result[i] = ele)
result = [[5,0], [7,0], [6,1], [7,1]]  (ele = [5,0], i = ele[1], result[i] = ele)

https://youtu.be/zx_64qoVVho?t=3845
Time: O(N^2 + N log N) = O(N^2), Space: O(N)
'''
from typing import List

def reconstructQueue(people: List[List[int]]) -> List[List[int]]:

    # sort first by descending order of age (h_i), then by ascending order of
    # no. of people in front (k_i)
    people_sorted = sorted(people, key = lambda x: (-x[0],x[1])) # O(N log N)
    # -x[0] -> descending order of x[0]
    #  x[1] -> ascending order of  x[1]

    result = []
    for p in people_sorted: # O(N)
        index = p[1]
        result.insert(index, p) # O(N)
    return result

def run_reconstructQueue():
    tests = [([[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]],
              [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]),
             ([[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]],
              [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]),
    ]
    for test in tests:
        people, ans = test[0], test[1]
        result = reconstructQueue(people)
        print(f"\npeople = {people}")
        print(f"result = {result}")
        success = (ans == result)
        print(f"Pass: {success}")
        if not success:
            print(f"Failed")
            return

run_reconstructQueue()