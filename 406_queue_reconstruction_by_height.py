"""

## Problem 406: Queue reconstruction by height

## Author: Neha Doiphode
## Date:   11-07-2022

## Description:
    You are given an array of people, people, which are the attributes of some people in a queue (not necessarily in order).
    Each people[i] = [hi, ki] represents the ith person of height hi with exactly ki other people
    in front who have a height greater than or equal to hi.

    Reconstruct and return the queue that is represented by the input array people.
    The returned queue should be formatted as an array queue, where queue[j] = [hj, kj]
    is the attributes of  the jth person in the queue (queue[0] is the person at the front of the queue).

## Examples:
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

## Constraints:
    1 <= people.length <= 2000
    0 <= hi <= 106
    0 <= ki < people.length
    It is guaranteed that the queue can be reconstructed.

## Time complexity: O(n^2) where n is number of elements in the list.
                        * O(n log n) to sort the list in descending order.
                        * Each insert operation is performed in O(k) times,
                          where k is the number of elements present in the list at a particular moment.
                          In our case, k grows from 0 to n - 1 so summation of 0 to n elements takes n(n + 1) / 2.
                          which is asymptotically takes O(n^2).

                        * Out of O(n log n) and O(n^2), we choose a bigger term which is O(n^2).

## Space complexity: O(n), to keep building the output or result list.

"""

from typing import List, Optional

def get_input():
    print("Enter total number of sub-lists in the list: ", end = "")
    num_sub_lists = int(input())
    inp_list = []
    for i in range(num_sub_lists):
        print(f"Sub-list {i + 1} (int 1 <space> int 2): ", end = "")
        temp_inp = input()
        temp = [int(element) for element in temp_inp.split()]
        inp_list.append(temp)
    print()
    return inp_list

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        if len(people) == 0:
            return people

        result = []

        # By intuition we arrange people in descending heights because the criteria for reconstruction is
        # people ahead of an element should be equal or greater than the element.
        # so we want person with height 7 to preceed the person with height 6.

        # between people of same height, [7, 1] and [7, 0], we choose to keep the ascending order
        # because in [h, index] -> second element is index so we can already have [7, 0] ahead of [7, 1] which
        # satisfies our criteria of having only 1 other pair ahead [7, 1] which has greater or same height as 7.
        people.sort(key = lambda k : [-k[0], k[1]])

        # Once we have the array sorted in descending order of heights,
        # we can just place elements based on their indices in the result list

        # original list = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
        # After sorting = [[7,0],[7,1],[6,1],[5,0],[5,2],[4,4]]

        # With each insert  = [[7,0]]
        #                   = [[7,0],[7,1]]
        #                   = [[7,0],[6,1],[7,1]
        #                   = [[5,0],[7,0],[6,1],[7,1]]
        #                   = [[5,0],[7,0],[5,2],[6,1],[7,1]]
        #                   = [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
        for p in people:
            result.insert(p[1], p)
        return result


# Driver code
solution = Solution()
inp_list = get_input()
print(f"Input queue: {inp_list}")
print(f"Output queue after the reconstruction: {solution.reconstructQueue(inp_list)}")
